package com.example.asrolearning;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;

import com.example.asrolearning.AsRoLearningContract.*;

import java.util.ArrayList;
import java.util.List;

public class AsRoLearningDBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "quiz";
    public static final int DATABASE_VERSION = 1;

    public static final String CATEGORY_SPRINGBOOT = "Spring Boot";
    public static final String CATEGORY_ANDROID = "ANDROID";
    public static final String CATEGORY_ANGULAR = "ANGULAR";
    public static final String CATEGORY_MONGO = "Mongo DB";
    public static final String CATEGORY_NODE = "NodeJS";
    private SQLiteDatabase db;
    private List<Questions> questionList;


    private final String CREATE_TABLE_QUERY = "CREATE TABLE " + QuestionsTable.TABLE_NAME +
            "(" +
            QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            QuestionsTable.COLUMN_QUESTION + " TEXT, " +
            QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
            QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
            QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
            QuestionsTable.COLUMN_OPTION4 + " TEXT, " +
            QuestionsTable.COLUMN_ANSWER + " TEXT, " +
            QuestionsTable.COLUMN_CATEGORY + " TEXT" +
            ")";

    private final String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME;


    public AsRoLearningDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);


    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;
        db.execSQL(CREATE_TABLE_QUERY);

        setUpQuestions();
        insertQuestions();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL(DROP_TABLE_QUERY);
        onCreate(db);

    }

    private void setUpQuestions() {
        questionList = new ArrayList<>();

        //questions for category spring Boot
        questionList.add(new Questions("Which of these is a valid Advice annotation?", "@AfterError", "@AfterReturning", "@AfterException", "@AfterExecution", "@AfterReturning", CATEGORY_SPRINGBOOT, ""));
        questionList.add(new Questions("What does a ViewResolver do?", "It supports internationalization of web applications by detecting a user's locale", "It generates a view by mapping a logical view name returned by a controller method to a view technology", "It creates a unique view determined by the uers's browser type,supporting cross-browser compatibility", "It maps custom parameters to SQL views in the database, allowing for dynamic content to be created in the response", "It generates a view by mapping a logical view name returned by a controller method to a view technology", CATEGORY_SPRINGBOOT, ""));
        questionList.add(new Questions("The process of linking aspects with other objects to create an advised object is called", "dynamic chaining", "banding", "weaving", "interleaving", "weaving", CATEGORY_SPRINGBOOT, ""));
        questionList.add(new Questions("What is the root interface for accessing a Spring bean container?", "SpringInitContainer", "ResourceLoader", "ApplicationEventPublisher", "BeanFactory", "BeanFactory", CATEGORY_SPRINGBOOT, ""));
        questionList.add(new Questions("Which of these is not a valid method on the JoinPoint interface?", "getArgs()", "getExceptions()", "getSignature()", "getTarget()", "getExceptions()", CATEGORY_SPRINGBOOT, ""));


        questionList.add(new Questions("Which annotation can be used within Spring Security to apply method level security?", "@Secured", "@RequiresRole", "@RestrictedTo", "@SecurePath", "@Secured", CATEGORY_SPRINGBOOT, ""));
        questionList.add(new Questions("Which property can be used to change the port of a Spring application?", "Port", "spring.port", "spring.settings.port", "server.port", "server.port", CATEGORY_SPRINGBOOT, ""));
        questionList.add(new Questions("What is the name of the central servlet that dispatches requests to controllers?", "DispatchingDelegatorServlet", "DispatcherServlet", " Router", "FrontControllerServlet", "DispatcherServlet", CATEGORY_SPRINGBOOT, ""));
        questionList.add(new Questions("Modularization of a concern that cuts across multiple classes is known as a(n)_", "multiclass", "aspect", "crosscut", "sidecut", "aspect", CATEGORY_SPRINGBOOT, ""));
        questionList.add(new Questions("Assuming no additional configuration is provided, what is the first selection criteria Spring uses to choose a bean when autowiring a property?", "none of these answers", "bean type", "bean size", " bean name", " bean name", CATEGORY_SPRINGBOOT, ""));


        //questions for category Angular
        questionList.add(new Questions("What is the RouterModule.forRoot method used for?", "Registering any providers that you intend to use in routed components.", "Registering route definitions at the root application level.", "Indicating that Angular should cheer on your routes to be successful.", "Declaring that you intend to use routing only at the root level.", "Registering route definitions at the root application level.", CATEGORY_ANGULAR, ""));
        questionList.add(new Questions("What are the two component decorator metadata properties used to set up CSS styles for a component?", "  viewEncapsulation and viewEncapsulationFiles.", "There is only one and it is the property named css.", "css and cssUrl.", "styles and styleUrls.", "styles and styleUrls.", CATEGORY_ANGULAR, ""));
        questionList.add(new Questions("What directive is used to link an <a> tag to routing?", " routeTo", "routerLink", "routePath", "appLink", "routerLink", CATEGORY_ANGULAR, ""));
        questionList.add(new Questions("You want to see what files would be generated by creating a new contact-card component. Which command would you use?", " ng generate component contact-card --dry-run", "ng generate component contact-card --no-files", "ng generate component component --dry", "ng generate component --exclude", "ng generate component contact-card --dry-run", CATEGORY_ANGULAR, ""));
        questionList.add(new Questions("What are Angular lifecycle hooks?", " loggers for tracking the health of an Angular app", "providers that can be used to track the instances of components", "built-in pipes that can be used in templates for DOM events", "reserved named methods for components and directives that Angular will call during set times in its execution, and can be used to tap into those lifecycle moments", "reserved named methods for components and directives that Angular will call during set times in its execution, and can be used to tap into those lifecycle moments", CATEGORY_ANGULAR, ""));


        questionList.add(new Questions("In order for Angular to process components in an application, where do the component types need to be registered?", " within a script tag in the index.html file", "in an NgModule decorator metadata tag named components", " No registration is needed simply include the component files in an app directory.", "in an NgModule decorator metadata property named declarations", "in an NgModule decorator metadata property named declarations", CATEGORY_ANGULAR, ""));
        questionList.add(new Questions("In reactive forms, what Angular form class type is used on the native DOM element to wire it up?", " FormArray", "FormControl", "FormGroup", "all of these answers", "FormGroup", CATEGORY_ANGULAR, ""));
        questionList.add(new Questions("How does the emulated view encapsulation mode handle CSS for a component?", "  It renders the CSS exactly how you wrote it without any changes.", "It makes use of shadow DOM markup and CSS.", "It creates unique attributes for DOM elements and scopes the CSS selectors you write to those attribute ids.", " It renders all of the CSS rules you write as inline CSS on all of the DOM elements you use them on in the template.\n", "It creates unique attributes for DOM elements and scopes the CSS selectors you write to those attribute ids.", CATEGORY_ANGULAR, ""));
        questionList.add(new Questions("What is the primary difference between a component and a directive?", " A component uses a selector metadata property and a directive does not.", "A directive can be used for adding custom events to the DOM and a component cannot.", "A component has a template and a directive does not.", "A directive can target only native DOM elements.", "A component has a template and a directive does not.", CATEGORY_ANGULAR, ""));
        questionList.add(new Questions("Pick the best description for this template syntax code: <span>Boss: {{job?.bossName}} </span>", " \n" +
                " The ? is shorthand for the async pipe. The job value must be an Observable.", " It is using the safe navigation operator (?) on the job field. If the job field is undefined, the access to the bossName will be ignored and no error will occur.", "There is an error in the template syntax. The ? is not valid here.", "It is diplaying the job value if it has one; otherwise it is displaying the bossName.", " It is using the safe navigation operator (?) on the job field. If the job field is undefined, the access to the bossName will be ignored and no error will occur.", CATEGORY_ANGULAR, ""));


        //questions for category Android
        questionList.add(new Questions("Which XML attribute should be used to make an Image View accessible?"," android:talkBack","android:labelFor","android:hint","android:contentDescription","android:contentDescription", CATEGORY_ANDROID, ""));
        questionList.add(new Questions("You want to include about and setting modules in your project. Which files accurately reflects their inclusion?","  in build.gradle:include ':app',':about' ':settings'","in settings.gradle:include ':app',':about' ':settings'","in settings.gradle:include ':about',':settings'","in gradle.properties:include ':app',':about' ':settings'","in settings.gradle:include ':app',':about' ':settings'", CATEGORY_ANDROID, ""));
        questionList.add(new Questions( "What is the benifit of using @VisibleForTesting annotation?"," to denote that a class, methos, or field has its visibility relaxed to make code testable","to denote that a class, method, or field is visible only in the test code","to denote that a class, method, or field has its visibility increased to make code less testable"," to throw a run-time error if a class, methos, or field with this annotation is accessed improperly","to denote that a class, methos, or field has its visibility relaxed to make code testable",CATEGORY_ANDROID, ""));
        questionList.add(new Questions( "When will an activity's onActivityResult()be called?"," when calling finish()in the parent activity","when placing an app into the background by sitching to another app","When onStop() is called in the target activity","when calling finish() in the target activity","when calling finish() in the target activity",CATEGORY_ANDROID, ""));
        questionList.add(new Questions(" When would you use a product flavour in your build setup?"," when you need to have the app's strings present in multiple lanuages","when you have to provide different versions of your app based on the physical device size","when you want to provide different versions of your app based on the device screen density","when you want to provide different version of your app with custom configuration and resources","when you want to provide different version of your app with custom configuration and resources", CATEGORY_ANDROID, ""));


        questionList.add(new Questions( "What allows you to properly restore a user's state when an activity is restarted?"," the onSaveInstance()method"," all of these answers","persistent storage","ViewModel objects","the onSaveInstance()method",CATEGORY_ANDROID, ""));
        questionList.add(new Questions("IF the main thread is blocked for too long, the system displays the _ dialog?"," Thread Not Responding","Application Paused"," Application Not Responding","Application Blocked"," Application Not Responding", CATEGORY_ANGULAR, ""));
        questionList.add(new Questions( "You need to get a list of devices that are attached to your computer with USB debugging enable. Which command would execute using the Android Debug Bridge?"," list devices"," adb devices"," list avd"," dir devices"," adb devices",CATEGORY_ANDROID, ""));
        questionList.add(new Questions( "To persist a small collection of key-value data, what should you use?"," external file storage","SharedPereferences","SQLite","internal file storage","SharedPereferences", CATEGORY_ANDROID, ""));
        questionList.add(new Questions( "Given the test class below, which code snippet would be a correct assertion?"," assertThat(resultAdd).is(2.0)","assertNotNull(resultAdd)","assertThat(resultAdd).isWqualTo(2.0)"," assertThat(resultAdd)","assertNotNull(resultAdd)",CATEGORY_ANDROID, ""));


        //questions for category Mongo
        questionList.add(new Questions("Which command adds members to the replica set from MongoDB shell?"," rs.add(\"<hostname>\")","replicaSetAdd(\"<hostname>\")","rs.insert(\"<hostname>\")","replica.add(\"<hostname>\")","rs.add(\"<hostname>\")",CATEGORY_MONGO, ""));
        questionList.add(new Questions(" Which MongoDB shell command should you use to back up a database?"," restore","backup","mongobackup","mongodump","mongodump",CATEGORY_MONGO, ""));
        questionList.add(new Questions("What does a MongoDB collection consist of?"," data","documents","fields","rows","documents",CATEGORY_MONGO, ""));
        questionList.add(new Questions("Given a cursor named myCursor, which command returns a boolean value?","  myCursor.hasNext()","myCursor.sort()"," myCursor.next()","myCursor.find()"," myCursor.hasNext()",CATEGORY_MONGO, ""));
        questionList.add(new Questions("Which command returns a specific document in the user's collection?"," db.users.find({_id: 1})","db.users.seek({_id: 1})"," db.users.query({_id: 1})","db.query.users({_id: 1})","db.users.find({_id: 1})",CATEGORY_MONGO, ""));
        questionList.add(new Questions("To import a JSON array into Mongo, what flags are needed with MongoDBimport?"," --type jsonArray"," --json","--type json","--jsonArray","--jsonArray",CATEGORY_MONGO, ""));
        questionList.add(new Questions("Choose the shell command that connects to a MongoDB database."," mongo","mongod","mongoconnect","dbconnect","mongo",CATEGORY_MONGO, ""));
        questionList.add(new Questions("In the MongoDB shell, how can you tell if an index was used with a query?","  db.customers.find({lastName: 'smith'}).explain()"," db.customers.find({lastName: 'smith'}).perf()","db.customers.find({lastName: 'smith'}).plan()"," db.customers.find({lastName: 'smith'}).usedIndex()"," db.customers.find({lastName: 'smith'}).explain()",CATEGORY_MONGO, ""));
        questionList.add(new Questions("What is the recommended way to delete a user?"," db.deleteUser(\"user\")","db.removeUser(\"user\") DEPRECATED","db.remove(\"user\")","db.dropUser(\"user\")","db.dropUser(\"user\")",CATEGORY_MONGO, ""));
        questionList.add(new Questions("What is the purpose of an arbiter in a replica set?"," It monitors replica set and sends email in case of failure"," It casts the tie-breaking vote in an election.","It holds a backup copy of the database.","It reboots the failed server."," It casts the tie-breaking vote in an election.",CATEGORY_MONGO, ""));


        //questions for category Node
        questionList.add(new Questions("When a javaScript function is invoked (called) in Node, where is a new frame placed?"," the call stack","the event loop","the poll phase"," the events queue","the call stack",CATEGORY_NODE, ""));
        questionList.add(new Questions("Which of the following is a core module in Node?"," webpack","crypto","request","chalk","crypto",CATEGORY_NODE, ""));
        questionList.add(new Questions("Which of the following Buffer class methods returns an uninitialized buffer?","  allocUnsafe","concat","from","alloc"," allocUnsafe",CATEGORY_NODE, ""));
        questionList.add(new Questions("Which of the following modules is NOT a built-in module in Node?"," ftp","events"," dgram","http2","ftp",CATEGORY_NODE, ""));
        questionList.add(new Questions("Which fs module method can be used to read the content of a file without buffering it in memory?"," read","readFile","createReadStream","readFileSync","createReadStream",CATEGORY_NODE, ""));
        questionList.add(new Questions("Which of the following DNS module methods uses the underlying OS facilities and does not necessarily perform any network communication?","  lookup","resolve","resolve4","reverse"," lookup",CATEGORY_NODE, ""));
        questionList.add(new Questions("How do you check that a value is a date object in Node?","  util.types.isDate(value)","assert.isDate(value)","console.isDate(value)","util.date(value)"," util.types.isDate(value)",CATEGORY_NODE, ""));
        questionList.add(new Questions("Can you create an https web server with Node.js?"," no, there are no modules supporting it yet","yes, with the https or http2 modules","yes, through the path module","yes, with the http module","yes, with the https or http2 modules",CATEGORY_NODE, ""));
        questionList.add(new Questions("Which of the following is a method on the console object?"," exit","test","time","print","time",CATEGORY_NODE, ""));
        questionList.add(new Questions("Which object is used to manage the cache of required modules?"," global.cache","module.cache","process.cache","require.cache","require.cache",CATEGORY_NODE, ""));


    }

    private void insertQuestions() {

        for (Questions q : questionList) {

            ContentValues contentValues = new ContentValues();
            contentValues.put(QuestionsTable.COLUMN_QUESTION, q.getQuestion());
            contentValues.put(QuestionsTable.COLUMN_OPTION1, q.getOption1());
            contentValues.put(QuestionsTable.COLUMN_OPTION2, q.getOption2());
            contentValues.put(QuestionsTable.COLUMN_OPTION3, q.getOption3());
            contentValues.put(QuestionsTable.COLUMN_OPTION4, q.getOption4());
            contentValues.put(QuestionsTable.COLUMN_ANSWER, q.getAnswer());
            contentValues.put(QuestionsTable.COLUMN_CATEGORY, q.getCategory());
            db.insert(QuestionsTable.TABLE_NAME, null, contentValues);


        }


    }

    @SuppressLint("Range")
    private ArrayList<Questions> spring() {
        ArrayList<Questions> questionList = new ArrayList<>();

        String SELECT_TABLE_QUERY = "SELECT * FROM " + QuestionsTable.TABLE_NAME + " WHERE " + QuestionsTable.COLUMN_CATEGORY + " = \"" + CATEGORY_SPRINGBOOT + "\"";
        Cursor cursor = db.rawQuery(SELECT_TABLE_QUERY, null);
        if (cursor.moveToFirst()) {
            do {
                Questions question = new Questions();
                question.setQuestion(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setOption4(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_OPTION4)));
                question.setAnswer(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_ANSWER)));
                questionList.add(question);
            } while (cursor.moveToNext());
        }
        cursor.close();

        return questionList;
    }

    @SuppressLint("Range")
    private ArrayList<Questions> angular() {
        ArrayList<Questions> questionList = new ArrayList<>();

        String SELECT_TABLE_QUERY = "SELECT * FROM " + QuestionsTable.TABLE_NAME + " WHERE " + QuestionsTable.COLUMN_CATEGORY + " = \"" + CATEGORY_ANGULAR + "\"";
        Cursor cursor = db.rawQuery(SELECT_TABLE_QUERY, null);
        if (cursor.moveToFirst()) {
            do {
                Questions question = new Questions();
                question.setQuestion(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setOption4(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_OPTION4)));
                question.setAnswer(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_ANSWER)));
                questionList.add(question);
            } while (cursor.moveToNext());
        }
        cursor.close();

        return questionList;
    }

    @SuppressLint("Range")
    private ArrayList<Questions> android() {
        ArrayList<Questions> questionList = new ArrayList<>();

        String SELECT_TABLE_QUERY = "SELECT * FROM " + QuestionsTable.TABLE_NAME + " WHERE " + QuestionsTable.COLUMN_CATEGORY + " = \"" + CATEGORY_ANDROID + "\"";
        Cursor cursor = db.rawQuery(SELECT_TABLE_QUERY, null);
        if (cursor.moveToFirst()) {
            do {
                Questions question = new Questions();
                question.setQuestion(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setOption4(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_OPTION4)));
                question.setAnswer(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_ANSWER)));
                questionList.add(question);
            } while (cursor.moveToNext());
        }
        cursor.close();

        return questionList;
    }

    @SuppressLint("Range")
    private ArrayList<Questions> mongo() {
        ArrayList<Questions> questionList = new ArrayList<>();

        String SELECT_TABLE_QUERY = "SELECT * FROM " + QuestionsTable.TABLE_NAME + " WHERE " + QuestionsTable.COLUMN_CATEGORY + " = \"" + CATEGORY_MONGO + "\"";
        Cursor cursor = db.rawQuery(SELECT_TABLE_QUERY, null);
        if (cursor.moveToFirst()) {
            do {
                Questions question = new Questions();
                question.setQuestion(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setOption4(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_OPTION4)));
                question.setAnswer(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_ANSWER)));
                questionList.add(question);
            } while (cursor.moveToNext());
        }
        cursor.close();

        return questionList;
    }

    @SuppressLint("Range")
    private ArrayList<Questions> node() {
        ArrayList<Questions> questionList = new ArrayList<>();

        String SELECT_TABLE_QUERY = "SELECT * FROM " + QuestionsTable.TABLE_NAME + " WHERE " + QuestionsTable.COLUMN_CATEGORY + " = \"" + CATEGORY_NODE + "\"";
        Cursor cursor = db.rawQuery(SELECT_TABLE_QUERY, null);
        if (cursor.moveToFirst()) {
            do {
                Questions question = new Questions();
                question.setQuestion(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setOption4(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_OPTION4)));
                question.setAnswer(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_ANSWER)));
                questionList.add(question);
            } while (cursor.moveToNext());
        }
        cursor.close();

        return questionList;
    }


    public ArrayList<Questions> getAllQuestions(String category) {
        Log.d("TAG", "Getting all questions for : " + category);
        db = getReadableDatabase();

        switch (category) {
            case "Spring Boot":
                return spring();

            case "Angular":
                return angular();

            case "Android":
                return android();

            case "Mongo DB":
                return mongo();
            case "NodeJS":
                return node();


            default:
                return spring();


        }


    }


}
