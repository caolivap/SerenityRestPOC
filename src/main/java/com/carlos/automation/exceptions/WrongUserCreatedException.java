package com.carlos.automation.exceptions;

public class WrongUserCreatedException extends AssertionError {

    public static final String WRONG_USER_CREATED = "The user sent and the user created are not equals";

    public WrongUserCreatedException(String message, Throwable cause) {
        super(message, cause);
    }
}
