package com.example.thirdlessonandroidapp;

import java.util.ArrayList;

public class Question {
    private String questionText;

    private ArrayList<String> answers = new ArrayList<>();

    private int imageId;

    private String hint;

    private int correctAnswerId;


    public Question(String questionText, ArrayList<String> answers, int imageId, String hint, int correctAnswerId) {
        this.questionText = questionText;
        this.answers = answers;
        this.imageId = imageId;
        this.hint = hint;
        this.correctAnswerId = correctAnswerId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<String> answers) {
        this.answers = answers;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public int getCorrectAnswerId() {
        return correctAnswerId;
    }

    public void setCorrectAnswerId(int correctAnswerId) {
        this.correctAnswerId = correctAnswerId;
    }

    public boolean isCorrectAnswer(int answer) {
        if (this.correctAnswerId == answer) {
            return true;
        } else {
            return false;
        }
    }
}
