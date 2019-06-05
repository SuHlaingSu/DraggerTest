package com.sh.draggertest.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;

import com.sh.draggertest.R;
import com.sh.draggertest.data.room.Movies;
import com.sh.draggertest.viewModel.MainActivityViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        viewModel.getFromAPI();
        viewModel.getListMutableLiveData().observe(this, new Observer<List<Movies>>() {
            @Override
            public void onChanged(List<Movies> movies) {
                if(movies != null)
                {
                    Log.d(TAG, "onChanged: Movie size is >> " +movies.size());
                }
                else {
                    Log.d(TAG, "onChanged: Movies is null");
                }
            }
        });


       
    }
}
