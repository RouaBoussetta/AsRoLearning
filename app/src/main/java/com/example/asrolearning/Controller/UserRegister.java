package com.example.asrolearning.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.asrolearning.DAO.UserDao;
import com.example.asrolearning.Models.User;
import com.example.asrolearning.R;
import com.example.asrolearning.DB.UserDatabase;

public class UserRegister extends AppCompatActivity {

    EditText  password , name, lastName ,email, phone;
    Button register;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);

       lastName = findViewById(R.id.lastName);
        password = findViewById(R.id.password);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);


        register = findViewById(R.id.register);
        login = findViewById(R.id.login);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //creating User Entity
                User user = new User();
                user.setLastName(lastName.getText().toString());
                user.setPassword(password.getText().toString());
                user.setName(name.getText().toString());
                user.setEmail(email.getText().toString());
                user.setPhone(phone.getText().toString());

                if(validateInput(user)) {
                    //Do insert operation
                    UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
                    UserDao userDao = userDatabase.userDao();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            //Register User
                            userDao.registerUser(user);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(), "User Registered ", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }).start();

                }else {
                    Toast.makeText(getApplicationContext(), "Fill all fields ", Toast.LENGTH_SHORT).show();
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserRegister.this, Login.class));
            }
        });





    }
    private Boolean validateInput(User  userEntity)
    {
        if (userEntity.getName().isEmpty() ||
                userEntity.getPassword().isEmpty() ||
                userEntity.getName().isEmpty() )
        {
            return false;
        }
        return  true;
    }




}