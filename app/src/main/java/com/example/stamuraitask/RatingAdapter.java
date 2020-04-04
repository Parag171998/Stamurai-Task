package com.example.stamuraitask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RatingAdapter extends RecyclerView.Adapter<RatingAdapter.ViewHolder> {

    LayoutInflater layoutInflater;
    List<RatingRoom> ratingRoomList;

    public RatingAdapter(Context context, List<RatingRoom> ratingRoomList) {
        this.layoutInflater = layoutInflater.from(context);
        this.ratingRoomList = ratingRoomList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.custom_recycler_layout,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.rating.setText("Rating = "+ratingRoomList.get(position).getRating());
        holder.date.setText("Date = "+ratingRoomList.get(position).getDate());
        holder.time.setText("Time = "+ratingRoomList.get(position).getTime());
    }

    @Override
    public int getItemCount() {
        return ratingRoomList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {

        TextView rating;
        TextView date;
        TextView time;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            rating = itemView.findViewById(R.id.custom_rating);
            date = itemView.findViewById(R.id.custom_date);
            time = itemView.findViewById(R.id.custom_time);
        }
    }

}
