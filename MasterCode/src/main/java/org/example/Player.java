package org.example;

import java.util.Scanner;
import java.io.InputStream;


public class Player {
    private final Scanner inputScanner;

    public Player() {
        this.inputScanner = new Scanner(System.in);
    }

    public Player(InputStream inputStream) {
        this.inputScanner = new Scanner(inputStream);
    }

    public String getGuess() {
        System.out.println("Enter 4 digit to unlock the master code:");
        String guess = inputScanner.nextLine();

        while (true) {
            if(guess.equalsIgnoreCase("quit") || guess.equalsIgnoreCase("exit") ){
                return guess;
            }
            if (guess.length() !=4 || !guess.matches("[1-8]+")) {
                System.out.println("Wrong input enter  exactly 4 digits (each from 1 to 8).");
                System.out.println("Enter 4 digit to unlock the master code:");
                guess = inputScanner.nextLine();

            }
            else {
                return guess;
            }
        }
    }
}


