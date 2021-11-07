package com.example.asrolearning.Controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.asrolearning.R;

public class QuizResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_results);




        final AppCompatButton startNewQuiz=findViewById(R.id.startNewQuiz);
        final TextView correctAnswer=findViewById(R.id.correctAnswers);
        final TextView wrongAnswer=findViewById(R.id.incorrectAnswer);
        final int getCorrectAnswer=getIntent().getIntExtra("correct",0);
        final int getInCorrectAnswer=getIntent().getIntExtra("incorrect",0);

        correctAnswer.setText(String.valueOf(getCorrectAnswer));
        wrongAnswer.setText(String.valueOf(getInCorrectAnswer));

        startNewQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(QuizResultsActivity.this, MainActivity.class));

                finish();
            }
        });

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(QuizResultsActivity.this,MainActivity.class));

        finish();
    }
}