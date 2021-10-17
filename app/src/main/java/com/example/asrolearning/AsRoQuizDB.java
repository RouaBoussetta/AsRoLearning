package com.example.asrolearning;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class AsRoQuizDB extends SQLiteOpenHelper {
    private static final String DATABASE_NAME= "";
    private static final int DATABASE_VERSION=1;
    private SQLiteDatabase db;

    public AsRoQuizDB(Context context) {
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        this.db=db;
        final String SQL_CREATE_QUESTIONS_TABLE="CREATE TABLE "+
                AsroQuiz.QuestionTable.TABLE_NAME+" ( "+
                AsroQuiz.QuestionTable._ID+ " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                AsroQuiz.QuestionTable.COLUMN_QUESTION +" TEXT,"+
                AsroQuiz.QuestionTable.COLUMN_OPTION1 +" TEXT,"+
        AsroQuiz.QuestionTable.COLUMN_OPTION2 +" TEXT,"+
        AsroQuiz.QuestionTable.COLUMN_OPTION3 +" TEXT,"+
        AsroQuiz.QuestionTable.COLUMN_OPTION4 +" TEXT,"+
        AsroQuiz.QuestionTable.COLUMN_ANSWER +" TEXT,"+")";

        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillQuestionsTable();

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
db.execSQL("DROP TABLE IF EXISTS "+AsroQuiz.QuestionTable.TABLE_NAME);
onCreate(db);
    }

    private void fillQuestionsTable(){
         QuestionsList question1=new QuestionsList("Which of these is a valid Advice annotation?","@AfterError","@AfterReturning","@AfterException","@AfterExecution","@AfterReturning","");
         addQuestion(question1);
          QuestionsList question2=new QuestionsList("What does a ViewResolver do?","It supports internationalization of web applications by detecting a user's locale","It generates a view by mapping a logical view name returned by a controller method to a view technology","It creates a unique view determined by the uers's browser type,supporting cross-browser compatibility","It maps custom parameters to SQL views in the database, allowing for dynamic content to be created in the response","It generates a view by mapping a logical view name returned by a controller method to a view technology","");
        addQuestion(question2);
           QuestionsList question3=new QuestionsList("The process of linking aspects with other objects to create an advised object is called","dynamic chaining","banding","weaving","interleaving","weaving","");
        addQuestion(question3);
          QuestionsList question4=new QuestionsList("Which of these is not a valid method on the JoinPoint interface?","getArgs()","getExceptions()","getSignature()","getTarget()","getExceptions()","");
        addQuestion(question4);
          QuestionsList question5=new QuestionsList("What is the root interface for accessing a Spring bean container?","SpringInitContainer","ResourceLoader","ApplicationEventPublisher","BeanFactory","BeanFactory","");
        addQuestion(question5);
           QuestionsList question6=new QuestionsList("Which annotation can be used within Spring Security to apply method level security?","@Secured","@RequiresRole","@RestrictedTo","@SecurePath","@Secured","");
        addQuestion(question6);
           QuestionsList question7=new QuestionsList("Which property can be used to change the port of a Spring application?","Port","spring.port","spring.settings.port","server.port","server.port","");
        addQuestion(question7);
          QuestionsList question8=new QuestionsList("What is the name of the central servlet that dispatches requests to controllers?","DispatchingDelegatorServlet","DispatcherServlet"," Router","FrontControllerServlet","DispatcherServlet","");
        addQuestion(question8);
          QuestionsList question9=new QuestionsList("Modularization of a concern that cuts across multiple classes is known as a(n)_","multiclass","aspect","crosscut","sidecut","aspect","");
        addQuestion(question9);
          QuestionsList question10=new QuestionsList("Assuming no additional configuration is provided, what is the first selection criteria Spring uses to choose a bean when autowiring a property?","none of these answers","bean type","bean size"," bean name"," bean name","");
        addQuestion(question10);
    }

    private void addQuestion(QuestionsList question){
        ContentValues cv=new ContentValues();
        cv.put(AsroQuiz.QuestionTable.COLUMN_QUESTION,question.getQuestion());
        cv.put(AsroQuiz.QuestionTable.COLUMN_OPTION1,question.getOption1());
        cv.put(AsroQuiz.QuestionTable.COLUMN_OPTION2,question.getOption2());
        cv.put(AsroQuiz.QuestionTable.COLUMN_OPTION3,question.getOption3());
        cv.put(AsroQuiz.QuestionTable.COLUMN_OPTION4,question.getOption4());
        cv.put(AsroQuiz.QuestionTable.COLUMN_ANSWER,question.getAnswer());
        db.insert(AsroQuiz.QuestionTable.TABLE_NAME,null,cv);

    }
}
