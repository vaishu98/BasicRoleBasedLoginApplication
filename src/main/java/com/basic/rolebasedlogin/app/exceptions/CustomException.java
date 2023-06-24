package com.basic.rolebasedlogin.app.exceptions;

public class CustomException extends RuntimeException {
    private static final long serialVerisionUID = 1;

    public CustomException(String message) {
        super(message);
    }
}
