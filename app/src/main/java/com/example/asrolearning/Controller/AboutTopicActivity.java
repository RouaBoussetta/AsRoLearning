package com.example.asrolearning.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asrolearning.DAO.UserDao;
import com.example.asrolearning.DB.TopicBank;
import com.example.asrolearning.DB.TopicDefinitions;
import com.example.asrolearning.DB.UserDatabase;
import com.example.asrolearning.Models.User;
import com.example.asrolearning.R;




public class AboutTopicActivity extends AppCompatActivity {

    private TopicDefinitions topicDefinition;

     String getSelectedTopic="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_topic);

        TextView tName = findViewById(R.id.name);
        String name = getIntent().getStringExtra("name");
        tName.setText(name);


        Button button = findViewById(R.id.viewPDF);
        final ImageView logoTopic=findViewById(R.id.logoTopic) ;

        final TextView description=findViewById(R.id.description) ;

        final Button start=findViewById(R.id.start) ;


        final TextView SelectedTopic=findViewById(R.id.topic);
         getSelectedTopic=getIntent().getStringExtra("selectedTopic");

        SelectedTopic.setText(getSelectedTopic);

        topicDefinition= TopicBank.getDefinition(getSelectedTopic);
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
                UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
                UserDao userDao = userDatabase.userDao();


                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        User user = userDao.getUser(name);

                        String current = user.getName();
                        startActivity(new Intent(
                                AboutTopicActivity.this, QuizActivity.class).putExtra("selectedTopic",getSelectedTopic)
                                .putExtra("name", current));

                    }
                }).start();


            }
        });
    }
}