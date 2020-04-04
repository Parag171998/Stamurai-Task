package com.example.stamuraitask.ui.home;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.stamuraitask.MyappDatabse;
import com.example.stamuraitask.R;
import com.example.stamuraitask.RatingRoom;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    EditText max;
    EditText min;
    Button range;
    Button set;
    Dialog myDialog;
    int maxInt;
    int minInt;
    public static MyappDatabse myappDatabse;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        myappDatabse = Room.databaseBuilder(getActivity(), MyappDatabse.class, "ratingdb").allowMainThreadQueries().build();
        //myappDatabse.mydao().deleteAll();
        min = root.findViewById(R.id.min);
         max = root.findViewById(R.id.max);
        range = root.findViewById(R.id.button);
        set = root.findViewById(R.id.set);
        myDialog = new Dialog(getContext());

        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String maxN = max.getText().toString();
                String minN = min.getText().toString();

                maxInt = Integer.parseInt(maxN);
                minInt = Integer.parseInt(minN);

                if(maxN.length() > 0 && minN.length() > 0 && Integer.parseInt(minN) < Integer.parseInt(maxN))
                {
                    range.setText("Rating "+minN+"-"+maxN);
                }
            }
        });

        range.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                myDialog.setContentView(R.layout.custompopup);
                final TextView rating = myDialog.findViewById(R.id.rating);
                Button submit = myDialog.findViewById(R.id.submit);

                SeekBar seekBar = myDialog.findViewById(R.id.seekBar);
                seekBar.setMax(Integer.parseInt(max.getText().toString()));
                seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        int minV = minInt;
                        if(i < minV)
                            i = minV;
                        rating.setText(String.valueOf(i));
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });

                myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                myDialog.show();

                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
                        String currentTime = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date());
                        RatingRoom ratingRoom = new RatingRoom(new Random().nextInt(100),rating.getText().toString(),currentDate,currentTime);
                        myappDatabse.mydao().addRatingRoom(ratingRoom);
                        Toast.makeText(getContext(), "Rating Added", Toast.LENGTH_SHORT).show();
                        myDialog.dismiss();
                    }
                });
            }
        });
        return root;
    }
}
