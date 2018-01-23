package com.example.mrsu.livedataroom_test;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity implements LifecycleOwner {

    private UserViewModel mUserViewModel;
    private static final String TAG = "MainActivity";

    private int position = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUserViewModel = ViewModelProviders.of(this).get(UserViewModel.class);
        LiveData<List<User>> listLiveData = mUserViewModel.getUsers();
        listLiveData.observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable List<User> users) {
                for (User user : users) {
                    Log.e(TAG, "名字: " + user.getUserName()+"===id:"+user.getId());
                }
            }
        });

    }

    public void onGetAllUserClick(View view) {
        position++;
        new Thread(new Runnable() {
            @Override
            public void run() {
                mUserViewModel.insertUser(new User(position +""));
            }
        }).start();
    }
}
