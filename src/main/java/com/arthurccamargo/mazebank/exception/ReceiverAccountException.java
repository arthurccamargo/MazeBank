package com.arthurccamargo.mazebank.exception;

public class ReceiverAccountException extends RuntimeException {
    public ReceiverAccountException() {
        super("This account is not from this receiver");
    }
}
