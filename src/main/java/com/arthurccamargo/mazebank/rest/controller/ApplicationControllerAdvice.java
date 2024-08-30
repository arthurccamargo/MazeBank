package com.arthurccamargo.mazebank.rest.controller;

import com.arthurccamargo.mazebank.exception.OutOfLimitException;
import com.arthurccamargo.mazebank.rest.dto.ApiErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationControllerAdvice { // catch errors / using exceptions handles
    @ExceptionHandler(OutOfLimitException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleRegraNegocioException(OutOfLimitException ex) {
        String errorMessage = ex.getMessage();
        return new ApiErrors(errorMessage);
    }
}
