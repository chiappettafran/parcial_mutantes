package org.example.parcial_mutantes.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidDnaException.class)
    public ResponseEntity<?> handleInvalidDnaException(InvalidDnaException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
