package com.sh.draggertest.di.modules;

import android.net.Uri;

import com.sh.draggertest.constant.Constants;
import com.sh.draggertest.data.network.MoviesAPI;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RetrofitModules {
    @Provides
    @Singleton
    public MoviesAPI getMoviesAPI (Retrofit retrofit)
    {
        return retrofit.create(MoviesAPI.class);
    }

    @Provides
    public Retrofit provideRetrofit(OkHttpClient okHttpClient)
    {
        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient).build();
    }

    @Provides
    public OkHttpClient provideOkHttpClient(HttpLoggingInterceptor httpLoggingInterceptor)
    {
        return new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
    }

    @Provides
    public HttpLoggingInterceptor providehttpLoggingInterceptor()
    {
        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    }
}
