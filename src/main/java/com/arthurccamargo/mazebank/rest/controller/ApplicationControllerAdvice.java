package com.arthurccamargo.mazebank.rest.controller;

import com.arthurccamargo.mazebank.exception.EqualAccountsException;
import com.arthurccamargo.mazebank.exception.ReceiverAccountException;
import com.arthurccamargo.mazebank.exception.SenderAccountException;
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
    public ApiErrors handleRulesException(OutOfLimitException ex) {
        String errorMessage = ex.getMessage();
        return new ApiErrors(errorMessage);
    }

    @ExceptionHandler(SenderAccountException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErrors handleRulesException(SenderAccountException ex) {
        String errorMessage = ex.getMessage();
        return new ApiErrors(errorMessage);
    }

    @ExceptionHandler(ReceiverAccountException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErrors handleRulesException(ReceiverAccountException ex) {
        String errorMessage = ex.getMessage();
        return new ApiErrors(errorMessage);
    }

    @ExceptionHandler(EqualAccountsException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErrors handleRulesException(EqualAccountsException ex) {
        String errorMessage = ex.getMessage();
        return new ApiErrors(errorMessage);
    }
}
