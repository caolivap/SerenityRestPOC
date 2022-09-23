package com.carlos.automation.exceptions;

public class WrongResponseCodeException extends AssertionError {

    public static final String WRONG_RESPONSE_CODE = "The response code is not correct";

    public WrongResponseCodeException(String message, Throwable cause) {
        super(message, cause);
    }
}
