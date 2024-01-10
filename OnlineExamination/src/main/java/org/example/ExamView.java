package org.example;

import static org.example.ExamPlatform.currentUser;
import static org.example.ExamPlatform.exams;

public class ExamView {

    static void viewExamResults() {
        if (currentUser.role == UserRole.STUDENT) {
            System.out.println("\nYour Exam Results:");
        } else {
            System.out.println("\nTeacher View: Exam Results");
            for (Examination exam : exams) {
                System.out.println("\nExam: " + exam.courseModule);
            }
        }
    }
}
