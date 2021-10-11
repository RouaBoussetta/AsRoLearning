package com.example.asrolearning;

public class TopicDefinitions {

    private  String description;

    private String userSelectedAnswer;


    public TopicDefinitions(String description, String userSelectedAnswer) {
        this.description = description;
        this.userSelectedAnswer = userSelectedAnswer;
    }


    public String getDescription() {
        return description;
    }





    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserSelectedAnswer() {
        return userSelectedAnswer;
    }

    public void setUserSelectedAnswer(String userSelectedAnswer) {
        this.userSelectedAnswer = userSelectedAnswer;
    }
}
