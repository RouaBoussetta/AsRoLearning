package com.example.asrolearning;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.asrolearning.AsRoLearningContract.*;
import java.util.ArrayList;
import java.util.List;

public class AsRoLearningDBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="AsRoLearningQuiz";
    public static final int DATABASE_VERSION=1;


    private  SQLiteDatabase db;
    public AsRoLearningDBHelper( Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }




    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db=db;
        final String SQL_CREATE_SPRING_TABLE="CREATE TABLE "+
                SpringQuestionsTable.TABLE_NAME+" ("+
                SpringQuestionsTable._ID+ " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                SpringQuestionsTable.COLUMN_QUESTION+ " TEXT,"+
                SpringQuestionsTable.COLUMN_OPTION1+ " TEXT,"+
                SpringQuestionsTable.COLUMN_OPTION2+ " TEXT,"+
                SpringQuestionsTable.COLUMN_OPTION3+ " TEXT,"+
                SpringQuestionsTable.COLUMN_OPTION4+ " TEXT,"+
                SpringQuestionsTable.COLUMN_ANSWER+ " TEXT"+")";
        db.execSQL(SQL_CREATE_SPRING_TABLE);

       SpringQuestions();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS "+SpringQuestionsTable.TABLE_NAME);
        onCreate(db);

    }

    private  void addQuestion(Questions questions){

        ContentValues cv=new ContentValues();
        cv.put(SpringQuestionsTable.COLUMN_QUESTION,questions.getQuestion());

        cv.put(SpringQuestionsTable.COLUMN_OPTION1,questions.getOption1());
        cv.put(SpringQuestionsTable.COLUMN_OPTION2,questions.getOption2());
        cv.put(SpringQuestionsTable.COLUMN_OPTION3,questions.getOption3());
        cv.put(SpringQuestionsTable.COLUMN_OPTION4,questions.getOption4());
        cv.put(SpringQuestionsTable.COLUMN_ANSWER,questions.getAnswer());

        db.insert(SpringQuestionsTable.TABLE_NAME,null,cv);
    }

    private  List<Questions> SpringQuestions(){
        final ArrayList <Questions> questionsLists=new ArrayList<>();

          Questions question1=new Questions("Which of these is a valid Advice annotation?","@AfterError","@AfterReturning","@AfterException","@AfterExecution","@AfterReturning","");
          Questions question2=new Questions("What does a ViewResolver do?","It supports internationalization of web applications by detecting a user's locale","It generates a view by mapping a logical view name returned by a controller method to a view technology","It creates a unique view determined by the uers's browser type,supporting cross-browser compatibility","It maps custom parameters to SQL views in the database, allowing for dynamic content to be created in the response","It generates a view by mapping a logical view name returned by a controller method to a view technology","");
          Questions question3=new Questions("The process of linking aspects with other objects to create an advised object is called","dynamic chaining","banding","weaving","interleaving","weaving","");
          Questions question4=new Questions("Which of these is not a valid method on the JoinPoint interface?","getArgs()","getExceptions()","getSignature()","getTarget()","getExceptions()","");
          Questions question5=new Questions("What is the root interface for accessing a Spring bean container?","SpringInitContainer","ResourceLoader","ApplicationEventPublisher","BeanFactory","BeanFactory","");
          Questions question6=new Questions("Which annotation can be used within Spring Security to apply method level security?","@Secured","@RequiresRole","@RestrictedTo","@SecurePath","@Secured","");
          Questions question7=new Questions("Which property can be used to change the port of a Spring application?","Port","spring.port","spring.settings.port","server.port","server.port","");
          Questions question8=new Questions("What is the name of the central servlet that dispatches requests to controllers?","DispatchingDelegatorServlet","DispatcherServlet"," Router","FrontControllerServlet","DispatcherServlet","");
          Questions question9=new Questions("Modularization of a concern that cuts across multiple classes is known as a(n)_","multiclass","aspect","crosscut","sidecut","aspect","");
          Questions question10=new Questions("Assuming no additional configuration is provided, what is the first selection criteria Spring uses to choose a bean when autowiring a property?","none of these answers","bean type","bean size"," bean name"," bean name","");

        questionsLists.add(question1);
        questionsLists.add(question2);
        questionsLists.add(question3);
        questionsLists.add(question4);
        questionsLists.add(question5);
        questionsLists.add(question6);
        questionsLists.add(question7);
        questionsLists.add(question8);
        questionsLists.add(question9);
        questionsLists.add(question10);

addQuestion(question1);


        db=getReadableDatabase();

        String Projection[]={
                SpringQuestionsTable._ID,
                SpringQuestionsTable.COLUMN_QUESTION,
                SpringQuestionsTable.COLUMN_OPTION1,
                SpringQuestionsTable.COLUMN_OPTION2,
                SpringQuestionsTable.COLUMN_OPTION3,
                SpringQuestionsTable.COLUMN_OPTION4,
                SpringQuestionsTable.COLUMN_ANSWER,

        };

        Cursor c=db.query(SpringQuestionsTable.TABLE_NAME,
                Projection,
                null,
                null,
                null,
                null,
                null);

        if (c.moveToFirst()){
            do {
                Questions questions=new Questions();
                questions.setQuestion(SpringQuestionsTable.COLUMN_QUESTION);
                questions.setOption1(SpringQuestionsTable.COLUMN_OPTION1);
                questions.setOption2(SpringQuestionsTable.COLUMN_OPTION2);
                questions.setOption3(SpringQuestionsTable.COLUMN_OPTION3);
                questions.setOption4(SpringQuestionsTable.COLUMN_OPTION4);
                questions.setAnswer(SpringQuestionsTable.COLUMN_ANSWER);

                questionsLists.add(questions);
            }while (c.moveToNext());
        }
        c.close();

        return questionsLists;



    }

    public List<Questions> getAllQuestions(String selectedTopicName){

        switch (selectedTopicName){
            case "Spring Boot": return SpringQuestions();

            default:return SpringQuestions();
        }
    }


}
