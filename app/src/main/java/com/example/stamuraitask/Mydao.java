package com.example.stamuraitask;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface Mydao {

    @Insert
    public void addRatingRoom(RatingRoom ratingRoom);

    @Query("select * from RatingRoom")
    public List<RatingRoom> getRatingRoom();

    @Query("DELETE FROM RatingRoom")
    public void deleteAll();
}
