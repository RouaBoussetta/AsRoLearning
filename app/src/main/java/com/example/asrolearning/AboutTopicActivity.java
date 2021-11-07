package com.example.asrolearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class AboutTopicActivity extends AppCompatActivity {

    private TopicDefinitions topicDefinition;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_topic);
        Button button = findViewById(R.id.viewPDF);

        final ImageView logoTopic=findViewById(R.id.logoTopic) ;

        final TextView description=findViewById(R.id.description) ;

        final Button start=findViewById(R.id.start) ;


        final TextView SelectedTopic=findViewById(R.id.topic);
        final String getSelectedTopic=getIntent().getStringExtra("selectedTopic");

        SelectedTopic.setText(getSelectedTopic);

        topicDefinition=TopicBank.getDefinition(getSelectedTopic);
        description.setText(topicDefinition.getDescription());

        if (getSelectedTopic.equals("Spring Boot")){
            logoTopic.setImageResource(R.drawable.spring);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), WebActivity.class);
                    intent.putExtra("pdf_url", "https://bottega.com.pl/pdf/materialy/SpringBootServices.pdf");
                    startActivity(intent);
                }
            });



        }
        if (getSelectedTopic.equals("Android")){
            logoTopic.setImageResource(R.drawable.android);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), WebActivity.class);
                    intent.putExtra("pdf_url", "https://web.stanford.edu/class/cs231m/lectures/lecture-2-android-dev.pdf");
                    startActivity(intent);
                }
            });



        }
        if (getSelectedTopic.equals("Angular")){
            logoTopic.setImageResource(R.drawable.angular);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), WebActivity.class);
                    intent.putExtra("pdf_url", "https://pageperso.lis-lab.fr/christophe.gonzales/teaching/mobile/polys/cours3_polys.pdf");
                    startActivity(intent);
                }
            });




        }
        if (getSelectedTopic.equals("Mongo DB")){
            logoTopic.setImageResource(R.drawable.mongo);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), WebActivity.class);
                    intent.putExtra("pdf_url", "https://www.tutorialspoint.com/mongodb/mongodb_tutorial.pdf");
                    startActivity(intent);
                }
            });



        }
        if (getSelectedTopic.equals("NodeJS")){
            logoTopic.setImageResource(R.drawable.node);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), WebActivity.class);
                    intent.putExtra("pdf_url", "https://www.tutorialspoint.com/nodejs/nodejs_tutorial.pdf");
                    startActivity(intent);
                }
            });


        }

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    Intent intent=new Intent(AboutTopicActivity.this,QuizActivity.class);
                intent.putExtra("selectedTopic",getSelectedTopic);
                    startActivity(intent);

            }
        });
    }
}