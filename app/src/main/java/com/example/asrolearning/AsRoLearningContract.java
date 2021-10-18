package com.example.asrolearning;

import android.provider.BaseColumns;

public final class AsRoLearningContract {
    public AsRoLearningContract(){

    }

    public static class SpringQuestionsTable implements BaseColumns{
        public static final String TABLE_NAME="spring_boot";
        public static final String COLUMN_QUESTION="question";
        public static final String COLUMN_OPTION1="option1";
        public static final String COLUMN_OPTION2="option2";
        public static final String COLUMN_OPTION3="option3";
        public static final String COLUMN_OPTION4="option4";
        public static final String COLUMN_ANSWER="answer";

    }


    public static class AndroidQuestionsTable implements BaseColumns{
        public static final String TABLE_NAME="android";
        public static final String COLUMN_QUESTION="question";

        public static final String COLUMN_OPTION1="option1";
        public static final String COLUMN_OPTION2="option2";
        public static final String COLUMN_OPTION3="option3";
        public static final String COLUMN_OPTION4="option4";
        public static final String COLUMN_ANSWER="answer";

    }
    public static class AngularQuestionsTable implements BaseColumns{
        public static final String TABLE_NAME="angular";
        public static final String COLUMN_QUESTION="question";
        public static final String COLUMN_OPTION1="option1";
        public static final String COLUMN_OPTION2="option2";
        public static final String COLUMN_OPTION3="option3";
        public static final String COLUMN_OPTION4="option4";
        public static final String COLUMN_ANSWER="answer";

    }
    public static class MongoQuestionsTable implements BaseColumns{
        public static final String TABLE_NAME="mongo";
        public static final String COLUMN_QUESTION="question";

        public static final String COLUMN_OPTION1="option1";
        public static final String COLUMN_OPTION2="option2";
        public static final String COLUMN_OPTION3="option3";
        public static final String COLUMN_OPTION4="option4";
        public static final String COLUMN_ANSWER="answer";

    }

    public static class NodeQuestionsTable implements BaseColumns{
        public static final String TABLE_NAME="nodejs";
        public static final String COLUMN_QUESTION="question";

        public static final String COLUMN_OPTION1="option1";
        public static final String COLUMN_OPTION2="option2";
        public static final String COLUMN_OPTION3="option3";
        public static final String COLUMN_OPTION4="option4";
        public static final String COLUMN_ANSWER="answer";

    }
}
