package com.carlos.automation.exceptions;

public class WrongInfoInBodyException extends AssertionError {

    public static final String WRONG_BODY_INFO = "The info in the response body is not correct";

    public WrongInfoInBodyException(String message, Throwable cause) {
        super(message, cause);
    }

}
