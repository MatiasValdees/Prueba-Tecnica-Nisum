package com.nisum.desafio.infrastructure.exceptions.catalog;

import lombok.Getter;

@Getter
public enum CatalogException {
    ENTITY_NOT_FOUND("ERR_001", "Entidad no encontrada."),
    EMAIL_EXIST("ERR_002", "Email ya existe."),
    PHONE_EXIST("ERR_003", "Télefono ya existe."),
    VALIDATION_REQUEST("ERR_005", "Error en la validacion de los datos.");

    private final String code;
    private final String message;

    CatalogException(String code, String message) {
        this.code = code;
        this.message = message;
    }
}