package com.example.stamuraitask.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stamuraitask.R;
import com.example.stamuraitask.RatingAdapter;
import com.example.stamuraitask.RatingRoom;
import com.example.stamuraitask.ui.home.HomeFragment;

import java.util.List;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;

    RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        recyclerView = root.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        List<RatingRoom> ratingRoomList = HomeFragment.myappDatabse.mydao().getRatingRoom();

        if(ratingRoomList != null && ratingRoomList.size() > 0)
        {
            RatingAdapter ratingAdapter = new RatingAdapter(getActivity(),ratingRoomList);
            recyclerView.setAdapter(ratingAdapter);
        }
        return root;
    }
}
