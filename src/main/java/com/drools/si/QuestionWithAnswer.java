package com.drools.si;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class QuestionWithAnswer {
    private String Question = "";
    private String Answer = "";
    private List<String> AnswerOptions = new ArrayList<>();
    private boolean isEndLeaf = false;

    public QuestionWithAnswer(String question) {
        Question = question;
    }

    public QuestionWithAnswer() {
    }

    public QuestionWithAnswer(QuestionWithAnswer qa) {
        this.Question = qa.Question;
        this.Answer = qa.Answer;
        //unused but important to keep every value
        this.AnswerOptions =qa.AnswerOptions;

    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String answer) {
        Answer = answer;
    }

    public List<String> getAnswerOptions() {
        return AnswerOptions;
    }

    public void setAnswerOptions(List<String> answerOptions) {
        AnswerOptions = answerOptions;
    }

    public void addBoolAnswers() {
        this.AnswerOptions.add("Yes");
        this.AnswerOptions.add("No");
    }

    public void setEndLeaf() {
        isEndLeaf = true;
    }

    public boolean isEndLeaf() {
        return isEndLeaf;
    }
}
