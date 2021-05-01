package com.scaler.backend.exceptions;

public class PersonDoesNotContainValidPhoneNumberException extends Throwable {
    public PersonDoesNotContainValidPhoneNumberException(String message) {
        super(message);
    }
}
