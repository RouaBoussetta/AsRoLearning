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

    private static List<QuestionsList> Topic2Questions(){

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


    public static List<QuestionsList> getQuestions(String selectedTopicName){
        switch (selectedTopicName){
            case "c1": return Topic1Questions();
            default:return Topic2Questions();
        }
    }


}
