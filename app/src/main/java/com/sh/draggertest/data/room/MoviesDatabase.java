package com.sh.draggertest.data.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Movies.class},version = 1,exportSchema = false)
public abstract class MoviesDatabase extends RoomDatabase {
    public abstract MoviesDAO moviesDAO();
}
