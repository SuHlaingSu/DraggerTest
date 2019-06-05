package com.sh.draggertest.di.modules;

import com.sh.draggertest.DraggerApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationContextModules {
    DraggerApplication application;

    public ApplicationContextModules(DraggerApplication draggerApplication) {
        this.application=draggerApplication;
    }

    @Provides
    @Singleton
    public DraggerApplication provideDraggerApplication()
    {
        return application;
    }
}
