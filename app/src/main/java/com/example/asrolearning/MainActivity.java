package com.example.asrolearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    /*private CircleImageView ProfileImage;
    private static final int PICK_IMAGE =1;*/

    TextView tName;
   // Uri imageUri;
    private String selectedTopic="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*ProfileImage = (CircleImageView) findViewById(R.id.profile_image);
        ProfileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent gallery = new Intent();
                gallery.setType("image/*");
                gallery.setAction(Intent.ACTION_GET_CONTENT);

                startActivityForResult(Intent.createChooser(gallery, "select Picture"), PICK_IMAGE);

            }
        });
*/







        tName = findViewById(R.id.name);
        String name = getIntent().getStringExtra("name");
        tName.setText(name);




        final LinearLayout springboot=findViewById(R.id.springBoot) ;

        final LinearLayout android=findViewById(R.id.android) ;
        final LinearLayout angular=findViewById(R.id.angular) ;
        final LinearLayout mongodb=findViewById(R.id.mongoDb) ;
        final LinearLayout nodejs=findViewById(R.id.nodeJs) ;
        final Button start=findViewById(R.id.start) ;


        springboot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           selectedTopic="Spring Boot";
                springboot.setBackgroundResource(R.drawable.round_back_white_stroke10);
                android.setBackgroundResource(R.drawable.round_background);
                angular.setBackgroundResource(R.drawable.round_background);
                mongodb.setBackgroundResource(R.drawable.round_background);
                nodejs.setBackgroundResource(R.drawable.round_background);
            }
        });


        android.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedTopic="Android";
                springboot.setBackgroundResource(R.drawable.round_background);
                android.setBackgroundResource(R.drawable.round_back_white_stroke10);
                angular.setBackgroundResource(R.drawable.round_background);
                mongodb.setBackgroundResource(R.drawable.round_background);
                nodejs.setBackgroundResource(R.drawable.round_background);

            }
        });
        angular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedTopic="Angular";
                springboot.setBackgroundResource(R.drawable.round_background);
                android.setBackgroundResource(R.drawable.round_background);
                angular.setBackgroundResource(R.drawable.round_back_white_stroke10);
                mongodb.setBackgroundResource(R.drawable.round_background);
                nodejs.setBackgroundResource(R.drawable.round_background);

            }
        });
        mongodb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedTopic="Mongo DB";
                springboot.setBackgroundResource(R.drawable.round_background);
                android.setBackgroundResource(R.drawable.round_background);
                angular.setBackgroundResource(R.drawable.round_background);
                mongodb.setBackgroundResource(R.drawable.round_back_white_stroke10);
                nodejs.setBackgroundResource(R.drawable.round_background);

            }
        });


        nodejs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedTopic="NodeJS";
                springboot.setBackgroundResource(R.drawable.round_background);
                android.setBackgroundResource(R.drawable.round_background);
                angular.setBackgroundResource(R.drawable.round_background);
                mongodb.setBackgroundResource(R.drawable.round_background);
                nodejs.setBackgroundResource(R.drawable.round_back_white_stroke10);

            }
        });


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (selectedTopic.isEmpty()){
                    Toast.makeText(MainActivity.this,"Please Select The Topic",Toast.LENGTH_SHORT).show();

                }else{
                    Intent intent=new Intent(MainActivity.this,AboutTopicActivity.class);
                    intent.putExtra("selectedTopic",selectedTopic);

                    startActivity(intent);
                }
            }
        });
    }




   /* protected void onActivityResult (int requestCode, int resultCode, Intent data)
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

*/








}