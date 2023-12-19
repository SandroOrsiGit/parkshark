package com.switchfully.parkshark.exception;

public class ManagerPasswordIncorrectException extends RuntimeException{
    public ManagerPasswordIncorrectException() {
        super("Password incorrect");
    }
}
