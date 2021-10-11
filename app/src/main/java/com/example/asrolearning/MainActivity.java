package com.example.asrolearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private String selectedTopic="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



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
}