package com.arthurccamargo.mazebank.exception;

public class SenderAccountException extends RuntimeException {
    public SenderAccountException() {
        super("This account is not from this sender");
    }
}
