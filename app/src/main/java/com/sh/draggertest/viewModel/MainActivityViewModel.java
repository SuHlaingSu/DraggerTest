package com.sh.draggertest.viewModel;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.sh.draggertest.DraggerApplication;
import com.sh.draggertest.constant.Constants;
import com.sh.draggertest.data.network.MoviesAPI;
import com.sh.draggertest.data.network.MoviesResponse;
import com.sh.draggertest.data.room.Movies;
import com.sh.draggertest.data.room.MoviesDAO;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

public class MainActivityViewModel extends AndroidViewModel {
    @Inject
    public MoviesAPI moviesAPI;
    @Inject
    public MoviesDAO moviesDAO;
    private static final String TAG = "MainActivityViewModel";
    private Disposable disposable = new CompositeDisposable();

    public MutableLiveData<List<Movies>> listMutableLiveData = new MutableLiveData<>();

    public MutableLiveData<List<Movies>> getListMutableLiveData()
    {
        return listMutableLiveData;
    }

    public MainActivityViewModel(Application application) {
        super(application);
        DraggerApplication.getApplication().getComponents().inject(this);
        if(moviesDAO == null)
        {
            Log.d(TAG, "MainActivityViewModel: MOVIE API IS NULL");
        }else {
            Log.d(TAG, "MainActivityViewModel: MOVIE API IS NOT NULL");
        }
    }

    public void getFromAPI()
    {
        disposable = moviesAPI.getPopularMovies(Constants.API_KEY)
                .subscribeOn(Schedulers.io()).observeOn(Schedulers.computation())
                .map(moviesResponseResponse -> moviesResponseResponse.body().getResults())
                .onErrorReturn(throwable -> null).subscribe(movies -> listMutableLiveData.postValue(movies));
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.dispose();
    }
}
