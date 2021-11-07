package com.example.asrolearning.DB;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.asrolearning.DAO.UserDao;
import com.example.asrolearning.Models.User;

@Database(entities = {User.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {

    private  static final String dbName = "asroLearning";
    private  static UserDatabase userDatabase;

    public static synchronized  UserDatabase getUserDatabase(Context context){
        if (userDatabase == null){
            userDatabase = Room.databaseBuilder(context.getApplicationContext(), UserDatabase.class, dbName).build();

        }
        return userDatabase;
    }
    public abstract UserDao userDao();
}
