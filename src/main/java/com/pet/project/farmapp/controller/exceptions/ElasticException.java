package com.pet.project.farmapp.controller.exceptions;

import org.springframework.http.HttpStatus;

public class ElasticException extends RuntimeException {
    private HttpStatus httpStatus;

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ElasticException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }

}
