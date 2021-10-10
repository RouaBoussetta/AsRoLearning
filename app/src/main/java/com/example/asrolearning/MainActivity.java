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



        final LinearLayout c1=findViewById(R.id.c1) ;

        final LinearLayout c2=findViewById(R.id.c2) ;
        final LinearLayout c3=findViewById(R.id.c3) ;
        final LinearLayout c4=findViewById(R.id.c4) ;
        final Button start=findViewById(R.id.start) ;


        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           selectedTopic="c1";
                c1.setBackgroundResource(R.drawable.round_back_white_stroke10);
                c2.setBackgroundResource(R.drawable.round_background);
                c3.setBackgroundResource(R.drawable.round_background);
                c4.setBackgroundResource(R.drawable.round_background);
            }
        });


        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedTopic="c2";
                c1.setBackgroundResource(R.drawable.round_background);
                c2.setBackgroundResource(R.drawable.round_back_white_stroke10);
                c3.setBackgroundResource(R.drawable.round_background);
                c4.setBackgroundResource(R.drawable.round_background);
            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedTopic="c3";
                c1.setBackgroundResource(R.drawable.round_background);
                c2.setBackgroundResource(R.drawable.round_background);
                c3.setBackgroundResource(R.drawable.round_back_white_stroke10);
                c4.setBackgroundResource(R.drawable.round_background);
            }
        });
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedTopic="c4";
                c1.setBackgroundResource(R.drawable.round_background);
                c2.setBackgroundResource(R.drawable.round_background);
                c3.setBackgroundResource(R.drawable.round_background);
                c4.setBackgroundResource(R.drawable.round_back_white_stroke10);
            }
        });

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (selectedTopic.isEmpty()){
                    Toast.makeText(MainActivity.this,"Please Select The Topic",Toast.LENGTH_SHORT).show();

                }else{
                    Intent intent=new Intent(MainActivity.this,QuizActivity.class);
                    intent.putExtra("selectedTopic",selectedTopic);
                    startActivity(intent);
                }
            }
        });
    }
}