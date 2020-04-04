package com.example.stamuraitask;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class RatingRoom {

    @PrimaryKey
    private int id;

    @ColumnInfo
    private String rating;

    @ColumnInfo
    private String date;

    @ColumnInfo
    private String time;

    public RatingRoom(int id, String rating, String date, String time) {
        this.id = id;
        this.rating = rating;
        this.date = date;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
