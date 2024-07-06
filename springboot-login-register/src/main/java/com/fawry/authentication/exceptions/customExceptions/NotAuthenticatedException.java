package com.fawry.authentication.exceptions.customExceptions;

public class NotAuthenticatedException extends RuntimeException {

    public NotAuthenticatedException() {
    }

    public NotAuthenticatedException(String message) {
        super(message);
    }

    public NotAuthenticatedException(String message, Throwable cause) {
        super(message, cause);
    }
}
