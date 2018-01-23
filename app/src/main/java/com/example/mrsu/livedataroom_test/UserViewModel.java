package com.example.mrsu.livedataroom_test;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.support.annotation.NonNull;

import java.util.List;

/**
 * Created by Mr.Su on 2018/1/23.
 * P:这里使用继承AndroidViewModel，而不是ViewModel
 *
 * 在领航项目中的写法是继承ViewModel
 */

public class UserViewModel extends AndroidViewModel {

    private UserDatabase mUserDatabase;

    public UserViewModel(@NonNull Application application) {
        super(application);

        mUserDatabase = UserDatabase.getInstance(application);
    }


    public LiveData<List<User>> getUsers() {
        return mUserDatabase.userDao().findAllUser();
    }

    public void insertUser(User user){
        mUserDatabase.userDao().insertUser(user);
    }
}
