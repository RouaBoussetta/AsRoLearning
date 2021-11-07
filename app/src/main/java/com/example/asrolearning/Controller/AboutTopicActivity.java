package com.example.asrolearning.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asrolearning.R;
import com.example.asrolearning.TopicBank;
import com.example.asrolearning.TopicDefinitions;


public class AboutTopicActivity extends AppCompatActivity {

    private TopicDefinitions topicDefinition;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_topic);

        final ImageView logoTopic=findViewById(R.id.logoTopic) ;

        final TextView description=findViewById(R.id.description) ;

        final Button start=findViewById(R.id.start) ;


        final TextView SelectedTopic=findViewById(R.id.topic);
        final String getSelectedTopic=getIntent().getStringExtra("selectedTopic");

        SelectedTopic.setText(getSelectedTopic);

        topicDefinition= TopicBank.getDefinition(getSelectedTopic);
        description.setText(topicDefinition.getDescription());

        if (getSelectedTopic.equals("Spring Boot")){
            logoTopic.setImageResource(R.drawable.spring);
        }
        if (getSelectedTopic.equals("Android")){
            logoTopic.setImageResource(R.drawable.android);
        }
        if (getSelectedTopic.equals("Angular")){
            logoTopic.setImageResource(R.drawable.angular);
        }
        if (getSelectedTopic.equals("Mongo DB")){
            logoTopic.setImageResource(R.drawable.mongo);
        }
        if (getSelectedTopic.equals("NodeJS")){
            logoTopic.setImageResource(R.drawable.node);


        }

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    Intent intent=new Intent(AboutTopicActivity.this, QuizActivity.class);
                intent.putExtra("selectedTopic",getSelectedTopic);
                    startActivity(intent);

            }
        });
    }
}