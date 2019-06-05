package com.sh.draggertest;

import android.app.Application;

import com.sh.draggertest.di.components.DaggerMoviesComponents;
import com.sh.draggertest.di.components.MoviesComponents;
import com.sh.draggertest.di.modules.ApplicationContextModules;

public class DraggerApplication extends Application {
    MoviesComponents components;
   static DraggerApplication application;

    public MoviesComponents getComponents()
    {
        return components;
    }

    public static DraggerApplication getApplication()
    {
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application = application;
        components = DaggerMoviesComponents.builder().applicationContextModules(new ApplicationContextModules(this)).build();
    }
}
