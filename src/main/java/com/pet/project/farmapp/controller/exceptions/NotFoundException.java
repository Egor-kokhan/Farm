package com.pet.project.farmapp.controller.exceptions;

import org.springframework.http.HttpStatus;

public class NotFoundException extends RuntimeException {
    private HttpStatus httpStatus;

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public NotFoundException() {
        super("Запись не найдена.");
        this.httpStatus = HttpStatus.NOT_FOUND;

    }

}
