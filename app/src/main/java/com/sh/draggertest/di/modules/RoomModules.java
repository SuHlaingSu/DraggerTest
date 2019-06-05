package com.sh.draggertest.di.modules;

import android.app.Application;

import androidx.room.Room;

import com.sh.draggertest.data.room.MoviesDAO;
import com.sh.draggertest.data.room.MoviesDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RoomModules {
    @Provides
    @Singleton
    public MoviesDAO provideMoviesDAO(MoviesDatabase moviesDatabase)
    {
        return moviesDatabase.moviesDAO();
    }
    @Provides
    public MoviesDatabase provideMoviesDatabase(Application application)
    {
        return  Room.databaseBuilder(application,MoviesDatabase.class,"movies.db").fallbackToDestructiveMigration().build();
    }
}
