package com.example.asrolearning.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.asrolearning.Models.User;

@Dao
public interface UserDao {
    @Insert
    void registerUser(User user );
    @Query("SELECT * from users where name =(:name) and password=(:password)")
    User  login(String name, String password);
}
