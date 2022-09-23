package com.carlos.automation.exceptions;

public class WrongUserUpdatedException extends AssertionError {

    public static final String WRONG_USER_UPDATED = "The user updated is not the correct or it was not updated";

    public WrongUserUpdatedException(String message, Throwable cause) {
        super(message, cause);
    }

}
