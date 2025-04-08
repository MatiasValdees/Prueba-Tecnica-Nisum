package com.nisum.desafio.domain.exceptions;

public class EmailExistException extends RuntimeException {
    public EmailExistException(String email) {
        super(String.format("Email %s already exists", email));
    }
}
