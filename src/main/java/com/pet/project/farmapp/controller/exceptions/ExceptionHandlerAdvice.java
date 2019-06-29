package com.pet.project.farmapp.controller.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(ElasticException.class)
    public ResponseEntity handleException(ElasticException e) {
        return ResponseEntity
                .status(e.getHttpStatus())
                .body(e.getMessage());
    }
}
