package org.example;

import java.util.Scanner;

import static org.example.ExamPlatform.exams;

public class WriteExam {
    static void takeExam(Scanner scanner) {
        System.out.println("\nAvailable Exams:");
        for (int i = 0; i < exams.size(); i++) {
            System.out.println((i + 1) + ". " + exams.get(i).courseModule);
        }

        System.out.print("Choose an exam to take: ");
        int examNumber = scanner.nextInt();
        scanner.nextLine();

        if (examNumber > 0 && examNumber <= exams.size()) {
            Examination selectedExam = exams.get(examNumber - 1);
            System.out.println("Taking " + selectedExam.courseModule);
            for (Question question : selectedExam.questions) {
                System.out.println("\nQuestion: " + question.text);
                if (question instanceof MultipleChoiceQuestion) {
                    MultipleChoiceQuestion mcq = (MultipleChoiceQuestion) question;
                    System.out.println("Options:");
                    for (int i = 0; i < mcq.options.size(); i++) {
                        System.out.println((i + 1) + ". " + mcq.options.get(i));
                    }
                }
                System.out.print("Your response: ");
                String response = scanner.nextLine();
                System.out.println("Your response is " + (question.isCorrect(response) ? "correct!" : "incorrect."));
            }
        } else {
            System.out.println("Invalid exam number.");
        }
    }
}
