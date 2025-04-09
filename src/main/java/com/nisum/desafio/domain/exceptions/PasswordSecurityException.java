package com.nisum.desafio.domain.exceptions;

import com.nisum.desafio.domain.models.SecurityParameter;

public class PasswordSecurityException extends RuntimeException {
    public PasswordSecurityException(String message) {
        super(String.format("Password does not meet security requirements: %s",message));
    }
}
