package com.example.myapplication.model;

public class Question {
    private String text;
    private String optionA;
    private String optionB;

    public Question(String text, String optionA, String optionB) {
        this.text = text;
        this.optionA = optionA;
        this.optionB = optionB;
    }

    public String getText() {
        return text;
    }

    public String getOptionA() {
        return optionA;
    }

    public String getOptionB() {
        return optionB;
    }
}
