package com.arthurccamargo.mazebank.exception;

public class OutOfLimitException extends RuntimeException {
    public OutOfLimitException() {
        super("Amount exceeds limit.");
    }
}
