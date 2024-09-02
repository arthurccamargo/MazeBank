package com.arthurccamargo.mazebank.exception;

public class EqualAccountsException extends RuntimeException{
    public EqualAccountsException() {
        super("Sender Account and Receiver Account are equal");
    }
}
