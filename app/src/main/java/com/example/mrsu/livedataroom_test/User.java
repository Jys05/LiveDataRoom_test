package com.example.mrsu.livedataroom_test;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by Mr.Su on 2018/1/23.
 */

@Entity
public class User {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;

    private String userName;


    public User(String userName) {
        this.userName = userName;
    }


    @NonNull
    public int getId() {
        return id;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
