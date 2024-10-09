package org.example.parcial_mutantes.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidDnaException extends RuntimeException {
  public InvalidDnaException(String message) {
    super(message);
  }
}
