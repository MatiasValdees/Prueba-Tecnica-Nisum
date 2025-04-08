package com.nisum.desafio.domain.exceptions;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String entity,String key,String value) {
        super(String.format("%s not found with %s: %s", entity, key, value));
    }
}
