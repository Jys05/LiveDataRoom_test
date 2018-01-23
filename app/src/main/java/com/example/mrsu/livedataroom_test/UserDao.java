package com.example.mrsu.livedataroom_test;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by Mr.Su on 2018/1/23.
 */
@Dao
public interface UserDao {

    @Insert
    void insertUser(User user);


    @Query("SELECT * FROM User")
    LiveData<List<User>> findAllUser();

}
