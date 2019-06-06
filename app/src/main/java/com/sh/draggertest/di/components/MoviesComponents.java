package com.sh.draggertest.di.components;

import com.sh.draggertest.data.room.MoviesDAO;
import com.sh.draggertest.di.modules.ApplicationContextModules;
import com.sh.draggertest.di.modules.RetrofitModules;
import com.sh.draggertest.di.modules.RoomModules;
import com.sh.draggertest.view.MainActivity;
import com.sh.draggertest.viewModel.MainActivityViewModel;

import javax.inject.Singleton;

import dagger.Component;
@Singleton
@Component(modules = {ApplicationContextModules.class,RetrofitModules.class, RoomModules.class})
public interface MoviesComponents {
    void inject (MainActivityViewModel mainActivityViewModel);
    MoviesDAO moviesDAO();

}
