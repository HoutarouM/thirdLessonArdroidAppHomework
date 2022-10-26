package com.example.thirdlessonandroidapp;

import java.util.ArrayList;

public class Question {
    static int counter = 0;

    private int id;

    private int questionText;

    private ArrayList<Integer> answers;

    private int imageId;

    private String hint;

    private int correctAnswerId;

    public Question(int questionText, ArrayList<Integer> answers, int imageId, String hint, int correctAnswerId) {
        this.id = counter++;
        this.questionText = questionText;
        this.answers = answers;
        this.imageId = imageId;
        this.hint = hint;
        this.correctAnswerId = correctAnswerId;
    }

    public int getImageId() {
        return imageId;
    }

    public int getQuestionText() {
        return questionText;
    }

    public ArrayList<Integer> getAnswers() {
        return answers;
    }

    public boolean isCorrectAnswer(int answer) {
        if (this.correctAnswerId == answer) {
            return true;
        } else {
            return false;
        }
    }
}
