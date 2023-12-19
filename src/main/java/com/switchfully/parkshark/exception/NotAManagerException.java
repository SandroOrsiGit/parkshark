package com.switchfully.parkshark.exception;

public class NotAManagerException extends RuntimeException{
    public NotAManagerException() {
        super("You are not a manager");
    }
}
