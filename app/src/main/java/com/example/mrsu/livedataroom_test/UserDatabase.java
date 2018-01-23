package com.example.mrsu.livedataroom_test;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by Mr.Su on 2018/1/23.
 */


@Database(entities = User.class, version = 1, exportSchema = false)
public abstract class UserDatabase extends RoomDatabase {

    private static volatile UserDatabase instance;

    public abstract UserDao userDao();

    public static UserDatabase getInstance(Context context) {
        if (instance == null) {
            synchronized (UserDatabase.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext()
                            , UserDatabase.class
                            , "user.db")
                            .build();
                }
            }
        }
        return instance;
    }
}
