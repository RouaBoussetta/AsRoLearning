package com.example.asrolearning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class QuizActivity extends AppCompatActivity {

private AppCompatButton option1,option2 ,option3 ,option4;
    private AppCompatButton nextBtn;
    private  TextView questions;
    private TextView question;

    private Timer quizTimer;
    private int totalTimeInMin=1;
    private int seconds=0;

    private List<QuestionsList> questionsLists;
    private  int  currentQuestionPosition =0;

    private  String selectedOptionByUser="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        final ImageView backbtn=findViewById(R.id.backbtn);
        final TextView SelectedTopicName=findViewById(R.id.topicName);
        final String getSelectedTopicName=getIntent().getStringExtra("selectedTopic");

        final TextView timer=findViewById(R.id.timer);
        SelectedTopicName.setText(getSelectedTopicName);


        questions=findViewById(R.id.questions);
        question=findViewById(R.id.question);
        option1=findViewById(R.id.option1);
        option2=findViewById(R.id.option2);
        option3=findViewById(R.id.option3);
        option4=findViewById(R.id.option4);
        nextBtn=findViewById(R.id.nextBtn);

       questionsLists=QuestionsBank.getQuestions(getSelectedTopicName);

       startTimer(timer);
      questions.setText((currentQuestionPosition+1)+"/"+questionsLists.size());
        question.setText(questionsLists.get(0).getQuestion());
        option1.setText(questionsLists.get(0).getQuestion());
        option2.setText(questionsLists.get(0).getQuestion());
        option3.setText(questionsLists.get(0).getQuestion());
        option4.setText(questionsLists.get(0).getQuestion());
        option1.setOnClickListener(view -> {

          if (selectedOptionByUser.isEmpty()){
                selectedOptionByUser=option1.getText().toString();
                option1.setBackgroundResource(R.drawable.round_back_red);
                option1.setTextColor(Color.WHITE);
               // revealAnswer();
                questionsLists.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);

            }
        });


        option2.setOnClickListener(view -> {
         if (selectedOptionByUser.isEmpty()){
                selectedOptionByUser=option2.getText().toString();
                option2.setBackgroundResource(R.drawable.round_back_red);
                option2.setTextColor(Color.WHITE);
                //revealAnswer();
                questionsLists.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);

            }
        });

        option3.setOnClickListener(view -> {
         if (selectedOptionByUser.isEmpty()){
                selectedOptionByUser=option3.getText().toString();
                option3.setBackgroundResource(R.drawable.round_back_red);
                option3.setTextColor(Color.WHITE);
               // revealAnswer();
                questionsLists.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);

            }
        });

        option4.setOnClickListener(view -> {
         if (selectedOptionByUser.isEmpty()){
                selectedOptionByUser=option4.getText().toString();
                option4.setBackgroundResource(R.drawable.round_back_red);
                option4.setTextColor(Color.WHITE);
               // revealAnswer();
                questionsLists.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);

            }
        });

        nextBtn.setOnClickListener(view -> {
            if (selectedOptionByUser.isEmpty()){
       Toast.makeText(QuizActivity.this,"Please Select an Option",Toast.LENGTH_SHORT).show();

            }else{
                changeNextQuestion();
            }
        });

        backbtn.setOnClickListener(view -> {
            quizTimer.purge();
            quizTimer.cancel();

            startActivity(new Intent(QuizActivity.this,MainActivity.class));
            finish();
        });
    }


    private void changeNextQuestion(){
        currentQuestionPosition++;
        if((currentQuestionPosition+1)==questionsLists.size()){
            nextBtn.setText("Submit Quiz");
        }
        if (currentQuestionPosition<questionsLists.size()){
            selectedOptionByUser="";
            option1.setBackgroundResource(R.drawable.round_back_white_stroke2);
            option1.setTextColor(Color.parseColor("#1F6888"));


            option2.setBackgroundResource(R.drawable.round_back_white_stroke2);
            option2.setTextColor(Color.parseColor("#1F6888"));

            option3.setBackgroundResource(R.drawable.round_back_white_stroke2);
            option3.setTextColor(Color.parseColor("#1F6888"));

            option4.setBackgroundResource(R.drawable.round_back_white_stroke2);
            option4.setTextColor(Color.parseColor("#1F6888"));

            questions.setText((currentQuestionPosition+1)+"/"+questionsLists.size());
            question.setText(questionsLists.get(currentQuestionPosition).getQuestion());
            option1.setText(questionsLists.get(currentQuestionPosition).getQuestion());
            option2.setText(questionsLists.get(currentQuestionPosition).getQuestion());
            option3.setText(questionsLists.get(currentQuestionPosition).getQuestion());
            option4.setText(questionsLists.get(currentQuestionPosition).getQuestion());
        }else
        {
            Intent intent=new Intent(QuizActivity.this,QuizResultsActivity.class);

            intent.putExtra("correct",getCorrectAnswers());
            intent.putExtra("Incorrect",getIncorrectAnswers());
            startActivity(intent);
            finish();

        }


    }


    private  void startTimer(TextView timerTextView){
        quizTimer=new Timer();
        quizTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                if (seconds==0){
                    totalTimeInMin--;
                    seconds=59;
                }else if(seconds==0 &&totalTimeInMin==0)
                {
                    quizTimer.purge();
                    quizTimer.cancel();
                    Toast.makeText(QuizActivity.this,"Time Over",Toast.LENGTH_SHORT).show();
                    Intent intent =new Intent(QuizActivity.this,QuizResultsActivity.class);
                    intent.putExtra("correct",  getCorrectAnswers());
                    intent.putExtra("incorrect",  getCorrectAnswers());
                    startActivity(intent);

                    finish();

                }
                else{
                    seconds--;
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String finalMinutes =String.valueOf(totalTimeInMin);
                        String finalSeconds =String.valueOf(seconds);

                       if (finalMinutes.length()==1){
                           finalMinutes="0"+finalMinutes;

                       }

                       if(finalSeconds.length()==1){
                           finalSeconds="0"+finalSeconds;

                       }

                       timerTextView.setText(finalMinutes+":"+finalSeconds);
                    }
                });
            }
        },1000,1000);

    }


    private int getCorrectAnswers(){
        int correctAnswers=0;
        for (int i=0;i<questionsLists.size();i++){
            final String getUserSelectedAnswer =questionsLists.get(i).getUserSelectedAnswer();
            final String getAnswer =questionsLists.get(i).getAnswer();

            if (getUserSelectedAnswer.equals(getAnswer)){
                correctAnswers++;

            }
        }
            return correctAnswers;
    }


    private int getIncorrectAnswers(){
        int correctAnswers=0;
        for (int i=0;i<questionsLists.size();i++){
            final String getUserSelectedAnswer =questionsLists.get(i).getUserSelectedAnswer();
            final String getAnswer =questionsLists.get(i).getAnswer();

            if (!getUserSelectedAnswer.equals(getAnswer)){
                correctAnswers++;

            }
        }
        return correctAnswers;
    }



    public void  onBackPressed(){
        quizTimer.purge();
        quizTimer.cancel();

        startActivity(new Intent(QuizActivity.this,MainActivity.class));
        finish();

    }



    private void revealAnswer(){
        final  String getAnswer= questionsLists.get(currentQuestionPosition).getAnswer();
        if(option1.getText().toString().equals(getAnswer)){
            option1.setBackgroundResource(R.drawable.round_back_green);
            option1.setTextColor(Color.WHITE);

        }else if(option2.getText().toString().equals(getAnswer)){
            option2.setBackgroundResource(R.drawable.round_back_green);
            option2.setTextColor(Color.WHITE);

        }else if(option3.getText().toString().equals(getAnswer)){
            option3.setBackgroundResource(R.drawable.round_back_green);
            option3.setTextColor(Color.WHITE);

        }else {
            option4.setBackgroundResource(R.drawable.round_back_green);
            option4.setTextColor(Color.WHITE);
        }


    }



}