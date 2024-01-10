package org.example;

abstract class Question {
    String text;

    Question(String text) {
        this.text = text;
    }

    abstract boolean isCorrect(String response);
}