/*package com.example.asrolearning;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.database.CursorWindow;

import java.lang.reflect.Field;

import android.app.AlertDialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.provider.MediaStore;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;




@SuppressWarnings("ALL")
public class ProfileActivity extends AppCompatActivity {

    public static UserEntity userprofile;
    private ImageView profileiv;
    private TextView name;
    private EditText lastName;
    private EditText email;
    private EditText password;
    private EditText phone;
    private Button btnedit;

   /* final int REQUEST_CODE_GALLERY = 999;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        btnedit = findViewById(R.id.btnedit);
        name =  findViewById(R.id.name);
        lastName =  findViewById(R.id.lastName);
        email = findViewById(R.id.email);
        password =  findViewById(R.id.password);
        phone = findViewById(R.id.phone);


        lastName.setText(userprofile.getLastName());
        email.setText(userprofile.getEmail());
        password.setText(userprofile.getPassword());
        phone.setText(userprofile.getPhone());
        name.setText(userprofile.getName()+" "+userprofile.getLastName());

        displayProfileImage();

        profileiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectImage(ProfileActivity.this);
            }
        });

        try {
            @SuppressLint("DiscouragedPrivateApi") Field field = CursorWindow.class.getDeclaredField("sCursorWindowSize");
            field.setAccessible(true);
            field.set(null, 100 * 1024 * 1024); //the 100MB is the new size
        } catch (Exception e) {
            if (e != null) {
                e.printStackTrace();
            }
        }


        btnedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String namestring = name.getText().toString();
                String lastNamestring = lastName.getText().toString();
                String emailstring = email.getText().toString();
                String passwordstring = password.getText().toString();
                String phonestring = phone.getText().toString();

                if (namestring.isEmpty()|| lastNamestring.isEmpty() || emailstring.isEmpty() || passwordstring.isEmpty()

                        || phonestring.isEmpty() )
                {
                    Toast.makeText(getApplicationContext(), "Some Fields are empty !", Toast.LENGTH_SHORT).show();

                }
                else {

                    UserDatabase db = UserDatabase.getDataBase(getApplicationContext());
                    db.UserDao.updateUserProfile(emailstring, namestring, lastNamestring, passwordstring, phonestring, ProfileActivity.userprofile.getId());
                    Toast.makeText(getApplicationContext(), "Profile updated successfully!", Toast.LENGTH_SHORT).show();
                    Intent profileintent = new Intent(ProfileActivity.this, MainActivity.class);
                    startActivity(profileintent);
                }
            }
        });

    }


    public void displayProfileImage()
    {

        MyDataBase database = MyDataBase.getDataBase(getApplicationContext());
        byte[] imageprofile = database.userdao().selectProfileImage(userprofile.getName());

        Bitmap bitmap = BitmapFactory.decodeByteArray(imageprofile, 0, imageprofile.length);

        profileiv.setImageBitmap(bitmap);
    }

    private void selectImage(Context context) {
        final CharSequence[] options = {"Take Photo", "Choose from Gallery", "Cancel"};

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Choose your profile picture");

        builder.setItems(options, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int item) {

                if (options[item].equals("Take Photo")) {
                    Intent takePicture = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(takePicture, 0);

                } else if (options[item].equals("Choose from Gallery")) {
                    Intent pickPhoto = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(pickPhoto, 1);

                } else if (options[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_CANCELED) {
            switch (requestCode) {
                case 0:

                    if (resultCode == RESULT_OK && data != null) {
                        Bitmap selectedImage = (Bitmap) data.getExtras().get("data");
                        profileiv.setImageBitmap(selectedImage);
                        MyDataBase db = MyDataBase.getDataBase(getApplicationContext());
                        UserDAO userdao = db.userdao();
                        userdao.updateUserImage(imageViewToByte(profileiv), userprofile.getName());
                    }

                    break;
                case 1:
                    if (resultCode == RESULT_OK && data != null) {
                        Uri selectedImage = data.getData();
                        String[] filePathColumn = {MediaStore.Images.Media.DATA};
                        if (selectedImage != null) {
                            Cursor cursor = getApplicationContext().getContentResolver().query(selectedImage,
                                    filePathColumn, null, null, null);
                            if (cursor != null) {
                                cursor.moveToFirst();
                                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                                String picturePath = cursor.getString(columnIndex);
                                profileiv.setImageBitmap(BitmapFactory.decodeFile(picturePath));
                                MyDataBase db = MyDataBase.getDataBase(getApplicationContext());
                                UserDAO userdao = db.userdao();
                                userdao.updateUserImage(imageViewToByte(profileiv), userprofile.getName());
                                cursor.close();
                            }
                        }

                    }
                    break;
            }
        }
    }

    public static byte[] imageViewToByte(ImageView image) {
        Bitmap bitmap = ((BitmapDrawable) image.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }


}
*/
