package com.sh.draggertest.di.modules;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModules {
    private final Context context;

    public MainActivityModules(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext()
    {
        return context;
    }
}
