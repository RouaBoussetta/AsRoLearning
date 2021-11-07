package com.example.asrolearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText  name , password;
    Button login;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        name = findViewById(R.id.name);
        password = findViewById(R.id.password);



        login = findViewById(R.id.login);
        register = findViewById(R.id.register);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameText = name.getText().toString();
                String passwordText = password.getText().toString();
                if (nameText.isEmpty() || passwordText.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Fill all fields" , Toast.LENGTH_SHORT).show();
                }else {
                    //Perform Query
                    UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
                    UserDao userDao = userDatabase.userDao();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            UserEntity userEntity = userDao.login(nameText, passwordText);
                            if (userEntity == null){
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getApplicationContext(), "Invalid credentials", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }else {
                                String name = userEntity.name;
                                startActivity(new Intent(
                                        Login.this, MainActivity.class)
                                        .putExtra("name", name));
                            }
                        }
                    }).start();
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, UserRegister.class));
            }
        });











    }
}