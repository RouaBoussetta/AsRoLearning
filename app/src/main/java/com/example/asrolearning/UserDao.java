package com.example.asrolearning;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UserDao {
    @Insert
    void registerUser(UserEntity userEntity);
    @Query("SELECT * from users where name =(:name) and password=(:password)")
    UserEntity login(String name, String password);






  /*  @Query("Update users set email=(:emailtomodify),name=(:nameTomodify),name=(:lastNameTomodify),password=(:passwordTomodify),phone=(:phoneTomodify) where id=(:id)")
    public void updateProfile(String emailtomodify,String nameTomodify,String lastNameTomodify,String passwordTomodify,String phoneTomodify,long id);*/

}
