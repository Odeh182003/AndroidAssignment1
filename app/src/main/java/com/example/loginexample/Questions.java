package com.example.loginexample;

public class Questions {
    private String question;
    private String[] answers;
    private int[] points;

    public Questions(String question, String[] answers,int[] points) {
        this.question = question;
        this.answers = answers;
        this.points=points;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getAnswers() {
        return answers;
    }

    public void setAnswers(String[] answers) {
        this.answers = answers;
    }

    public int[] getPoints() {
        return points;
    }

    public void setChoice(int[] points) {
        this.points = points;
    }
}
