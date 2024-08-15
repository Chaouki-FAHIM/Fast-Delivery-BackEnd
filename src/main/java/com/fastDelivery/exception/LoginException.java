package com.fastDelivery.exception;

public class LoginException extends Exception {

    public LoginException() {
        super("Invalid email or password");
    }
}
