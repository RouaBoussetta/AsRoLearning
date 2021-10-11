package com.example.asrolearning;

import java.util.ArrayList;
import java.util.List;

public class QuestionsBank {

    private static List<QuestionsList> Topic1Questions(){

        final List <QuestionsList> questionsLists=new ArrayList<>();

        final QuestionsList question1=new QuestionsList("what is the size of int variable","16 bit","aa","aa","aa","aa","");
        final QuestionsList question2=new QuestionsList("what is the size of int variable","16 bit","aa","aa","aa","aa","");
        final QuestionsList question3=new QuestionsList("what is the size of int variable","16 bit","aa","aa","aa","aa","");
        final QuestionsList question4=new QuestionsList("what is the size of int variable","16 bit","aa","aa","aa","aa","");

        questionsLists.add(question1);
        questionsLists.add(question2);
        questionsLists.add(question3);
        questionsLists.add(question4);


        return questionsLists;
    }

    private static List<QuestionsList> MavenQuestions(){

        final List <QuestionsList> questionsLists=new ArrayList<>();

        final QuestionsList question1=new QuestionsList("What element in the pom.xml file allows you to provide values that can be reused in other elements of the pom.xml?"," Plugins","Build","Properties","Parent","Parent","");
        final QuestionsList question2=new QuestionsList(" If you wish to build and package your artifact using the Maven package goal but don't want to execute the unit tests, which environment variable and value would you use?","maven.test.ignore=TRUE","maven.test.run=FALSE","maven.test.skip=TRUE"," maven.verify.execute=FALSE","maven.test.skip=TRUE","");
        final QuestionsList question3=new QuestionsList("What directory structure contains the source code of your artifact?"," src/code"," src/test/java"," src/main/java"," src/main/resources"," src/main/java","");
        final QuestionsList question4=new QuestionsList("Which command is used to run the clean lifecyle followed by verify, install, and package with Maven?","mvn package","mvn clean install package","mvn clean install","mvn clear install","mvn package","");

        questionsLists.add(question1);
        questionsLists.add(question2);
        questionsLists.add(question3);
        questionsLists.add(question4);


        return questionsLists;
    }


    public static List<QuestionsList> getQuestions(String selectedTopicName){
        switch (selectedTopicName){
            case "c1": return Topic1Questions();
            case "c2": return MavenQuestions();
            default:return Topic1Questions();
        }
    }


}
