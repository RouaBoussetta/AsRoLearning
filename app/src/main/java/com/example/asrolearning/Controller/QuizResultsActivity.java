package com.example.asrolearning.Controller;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.example.asrolearning.R;


public class QuizResultsActivity extends AppCompatActivity {
    private String getSelectedTopicName="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_results);
        TextView tName = findViewById(R.id.name);
        String name = getIntent().getStringExtra("name");
        tName.setText(name);

        final AppCompatButton startNewQuiz=findViewById(R.id.startNewQuiz);
        final TextView correctAnswer=findViewById(R.id.correctAnswers);
        final TextView wrongAnswer=findViewById(R.id.incorrectAnswer);
        final int getCorrectAnswer=getIntent().getIntExtra("correct",0);
        final int getInCorrectAnswer=getIntent().getIntExtra("incorrect",0);
        RelativeLayout background = (RelativeLayout) findViewById(R.id.r1);
        if(getCorrectAnswer>5){
            TextView textmsg = findViewById(R.id.Text);
            getSelectedTopicName=getIntent().getStringExtra("selectedTopic");
            textmsg.setText("Good Job "+name+",\n Congratulations You Are Certified In\n"+getSelectedTopicName+" Course.");

            background.setBackgroundResource(R.drawable.congratulation);
        correctAnswer.setText(String.valueOf(getCorrectAnswer));
        wrongAnswer.setText(String.valueOf(getInCorrectAnswer));}

        if(getInCorrectAnswer>5){
            background.setBackgroundResource(R.drawable.sad);
            TextView textmsg = findViewById(R.id.Text);
            getSelectedTopicName=getIntent().getStringExtra("selectedTopic");
            textmsg.setText("Sorry "+name+",\n You Have To Revise \n "+getSelectedTopicName+" Course Again");

            correctAnswer.setText(String.valueOf(getCorrectAnswer));
            wrongAnswer.setText(String.valueOf(getInCorrectAnswer));

        }


        startNewQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                startActivity(new Intent(QuizResultsActivity.this, MainActivity.class));
                finish();
            }
        });

    }


}