package com.sh.draggertest.data.network;

import io.reactivex.Flowable;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MoviesAPI {
    @GET("movie/popular")
    Flowable<Response<MoviesResponse>> getPopularMovies(@Query("api_key") String api_key);
}
