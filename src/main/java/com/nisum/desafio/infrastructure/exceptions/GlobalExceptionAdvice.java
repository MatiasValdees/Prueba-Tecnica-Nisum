package com.nisum.desafio.infrastructure.exceptions;

import com.nisum.desafio.domain.exceptions.EmailExistException;
import com.nisum.desafio.domain.exceptions.EntityNotFoundException;
import com.nisum.desafio.domain.exceptions.PhoneExistException;
import com.nisum.desafio.infrastructure.exceptions.catalog.CatalogException;
import com.nisum.desafio.infrastructure.exceptions.dto.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.Objects;

@ControllerAdvice
public class GlobalExceptionAdvice {
    private final String ERROR="ERROR";

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ExceptionResponse>handleEntityNotFoundException(EntityNotFoundException exception) {
        ExceptionResponse response = new ExceptionResponse(
                ERROR,
                LocalDateTime.now(),
                CatalogException.ENTITY_NOT_FOUND.getCode(),
                CatalogException.ENTITY_NOT_FOUND.getMessage(),
                exception.getMessage()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(EmailExistException.class)
    public ResponseEntity<ExceptionResponse>handleEntityEmailExistException(EmailExistException exception) {
        ExceptionResponse response = new ExceptionResponse(
                ERROR,
                LocalDateTime.now(),
                CatalogException.EMAIL_EXIST.getCode(),
                CatalogException.EMAIL_EXIST.getMessage(),
                exception.getMessage()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
    @ExceptionHandler(PhoneExistException.class)
    public ResponseEntity<ExceptionResponse>handlePhoneExistException(PhoneExistException exception) {
        ExceptionResponse response = new ExceptionResponse(
                ERROR,
                LocalDateTime.now(),
                CatalogException.PHONE_EXIST.getCode(),
                CatalogException.PHONE_EXIST.getMessage(),
                exception.getMessage()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        String bodyError= Objects.requireNonNull(exception.getFieldError()).getField() + ": " + exception.getFieldError().getDefaultMessage();
        ExceptionResponse response = new ExceptionResponse(
                ERROR,
                LocalDateTime.now(),
                CatalogException.VALIDATION_REQUEST.getCode(),
                CatalogException.VALIDATION_REQUEST.getMessage(),
                bodyError
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

}
