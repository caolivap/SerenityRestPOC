package com.carlos.automation.utils;

import org.hamcrest.Matchers;

public class EmailManagement {

    public static String generateValidEmail(String username) {
        if (!username.contains("@")) {
            String usernameNumber = Integer.toString(generateRandomNumber(1000));
            return username + usernameNumber + "@example.com";
        }
        return username;
    }

    public static int generateRandomNumber(int maxNumber) {
        return (int) (Math.random() * maxNumber);
    }

}
