package com.sh.draggertest.di.modules;

import android.app.Application;

import com.sh.draggertest.DraggerApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationContextModules {
    Application application;

    public ApplicationContextModules(Application draggerApplication) {
        this.application=draggerApplication;
    }

    @Provides
    @Singleton
    public Application provideDraggerApplication()
    {
        return application;
    }
}
