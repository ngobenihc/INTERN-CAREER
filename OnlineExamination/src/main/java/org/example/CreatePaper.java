package org.example;

import java.util.List;
import java.util.Scanner;

import static org.example.ExamPlatform.exams;

public class CreatePaper {

    static void createQuestionPaper(Scanner scanner) {
        System.out.print("Enter the code of the new exam: ");
        String title = scanner.nextLine();
        System.out.print("Enter the duration of the new exam (in minutes): ");
        int duration = scanner.nextInt();
        scanner.nextLine();

        Examination newExam = new Examination(title, duration);

        while (true) {
            System.out.println("\nAdd Questions to the Exam:");
            System.out.println("1. Multiple-Choice Question");
            System.out.println("2. Short Answer Question");
            System.out.println("3. Finish Exam Creation");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter the text of the multiple-choice question: ");
                    String mcqText = scanner.nextLine();
                    System.out.println("Enter the options (comma-separated): ");
                    List<String> mcqOptions = List.of(scanner.nextLine().split(","));
                    System.out.print("Enter the correct option number: ");
                    int correctOption = scanner.nextInt();
                    scanner.nextLine();

                    newExam.addQuestion(new MultipleChoiceQuestion(mcqText, mcqOptions, correctOption));
                    break;
                case 2:
                    System.out.print("Enter the text of the short answer question: ");
                    String saqText = scanner.nextLine();
                    System.out.print("Enter the correct answer: ");
                    String correctAnswer = scanner.nextLine();

                    newExam.addQuestion(new ShortAnswerQuestion(saqText, correctAnswer));
                    break;
                case 3:
                    exams.add(newExam);
                    System.out.println("Exam creation completed.");
                    return;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }
}
