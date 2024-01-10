package org.example;

class ShortAnswerQuestion extends Question {
    String correctAnswer;

    ShortAnswerQuestion(String text, String correctAnswer) {
        super(text);
        this.correctAnswer = correctAnswer;
    }

    @Override
    boolean isCorrect(String response) {
        return response.equalsIgnoreCase(correctAnswer);
    }
}