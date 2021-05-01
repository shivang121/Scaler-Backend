package com.scaler.backend.exceptions;

public class PersonDoesNotContainValidNameException extends Throwable {
    public PersonDoesNotContainValidNameException(String message) {
        super(message);
    }
}
