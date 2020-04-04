package com.example.stamuraitask;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {RatingRoom.class},version = 1)
public abstract class MyappDatabse extends RoomDatabase {

    public abstract Mydao mydao();

}
