package com.sh.draggertest.data.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MoviesDAO {
    @Query("SELECT * FROM movies")
    public List<Movies> getAllMovies();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertMovies(Movies movies) ;

    @Update(onConflict = OnConflictStrategy.REPLACE)
    public void updateMovies(Movies movies);

    @Delete
    public void delete(Movies movies);

}
