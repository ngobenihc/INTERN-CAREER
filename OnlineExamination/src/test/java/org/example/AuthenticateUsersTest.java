package org.example;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AuthenticateUsersTest {

    @Test
    void testAuthenticateUserSuccessful() {
        // Arrange
        Map<String, UserInput> users = new HashMap<>();
        UserInput validUser = new UserInput("validUser", "validPassword");
        users.put("validUser", validUser);
        ExamPlatform.users = users;

        String input = "validUser\nvalidPassword\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Scanner scanner = new Scanner(System.in);

        // Act
        UserInput authenticatedUser = AuthenticateUsers.authenticateUser(scanner);

        // Assert
        assertNotNull(authenticatedUser);
        assertEquals(validUser, authenticatedUser);
    }

    @Test
    void testAuthenticateUserInvalidCredentials() {
        // Arrange
        Map<String, UserInput> users = new HashMap<>();
        UserInput validUser = new UserInput("validUser", "validPassword");
        users.put("validUser", validUser);
        ExamPlatform.users = users;

        String input = "invalidUser\ninvalidPassword\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Scanner scanner = new Scanner(System.in);

        // Act
        UserInput authenticatedUser = AuthenticateUsers.authenticateUser(scanner);

        // Assert
        assertNull(authenticatedUser);
    }
}
