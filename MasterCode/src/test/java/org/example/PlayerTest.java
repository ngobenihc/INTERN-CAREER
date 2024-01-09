package org.example;

import org.example.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void testGuessCorrect() {
        Player player = new Player(new ByteArrayInputStream("6135\n".getBytes()));
        String guess = player.getGuess();
        assertEquals("6135", guess);
    }

    @Test
    void testGuessTooShort() {
        Player player = new Player(new ByteArrayInputStream("632\n6543\n".getBytes()));
        String guess = player.getGuess();
        assertEquals("6543", guess);
        assertEquals(
                "Enter 4 digit to unlock the master code:\nWrong input enter  exactly 4 digits (each from 1 to 8).\nEnter 4 digit to unlock the master code:",
                outputStreamCaptor.toString().trim());

    }

    @Test
    void testGuessTooLong() {
        Player player = new Player(new ByteArrayInputStream("54561\n4512\n".getBytes()));
        String guess = player.getGuess();
        assertEquals("4512", guess);
        assertEquals(
                "Enter 4 digit to unlock the master code:\nWrong input enter  exactly 4 digits (each from 1 to 8).\nEnter 4 digit to unlock the master code:",
                outputStreamCaptor.toString().trim());

    }

    @Test
    void testGuessNotDigits() {
        Player player = new Player(new ByteArrayInputStream("mn54\n4512\n".getBytes()));
        String guess = player.getGuess();
        assertEquals("4512", guess);
        assertEquals(
                "Enter 4 digit to unlock the master code:\nWrong input enter  exactly 4 digits (each from 1 to 8).\nEnter 4 digit to unlock the master code:",
                outputStreamCaptor.toString().trim());

    }

    @Test
    void testGuessEmpty() {
        Player player = new Player(new ByteArrayInputStream("\n4621\n".getBytes()));
        String guess = player.getGuess();
        assertEquals("4621", guess);
        assertEquals(
                "Enter 4 digit to unlock the master code:\nWrong input enter  exactly 4 digits (each from 1 to 8).\nEnter 4 digit to unlock the master code:",
                outputStreamCaptor.toString().trim());

    }

    @Test
    void testGuessNotInRageLow() {
        Player player = new Player(new ByteArrayInputStream("0564\n5642\n".getBytes()));
        String guess = player.getGuess();
        assertEquals("5642", guess);
        assertEquals(
                "Enter 4 digit to unlock the master code:\nWrong input enter  exactly 4 digits (each from 1 to 8).\nEnter 4 digit to unlock the master code:",
                outputStreamCaptor.toString().trim());

    }

    @Test
    void testGuessNotInRageHigh() {
        Player player = new Player(new ByteArrayInputStream("4519\n4561\n".getBytes()));
        String guess = player.getGuess();
        assertEquals("4561", guess);
        assertEquals(
                "Enter 4 digit to unlock the master code:\nWrong input enter  exactly 4 digits (each from 1 to 8).\nEnter 4 digit to unlock the master code:",
                outputStreamCaptor.toString().trim());

    }

}