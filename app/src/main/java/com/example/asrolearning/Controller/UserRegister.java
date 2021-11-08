package com.example.asrolearning.Controller;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.asrolearning.DAO.UserDao;
import com.example.asrolearning.Models.User;
import com.example.asrolearning.R;
import com.example.asrolearning.DB.UserDatabase;

import java.io.IOException;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserRegister extends AppCompatActivity {
    private CircleImageView ProfileImage;
    private static final int PICK_IMAGE =1;
    EditText  password , name, lastName ,email, phone;
    Button register;
    Button login;
    Uri imageUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);
        ProfileImage = (CircleImageView) findViewById(R.id.profile_image);
        ProfileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent gallery = new Intent();
                gallery.setType("image/*");
                gallery.setAction(Intent.ACTION_GET_CONTENT);

                startActivityForResult(Intent.createChooser(gallery, "select Picture"), PICK_IMAGE);

            }
        });


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
                user.setProfileImage(imageUri.toString());
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

    protected void onActivityResult (int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK){
            imageUri = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);
                ProfileImage.setImageBitmap(bitmap);
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }


}