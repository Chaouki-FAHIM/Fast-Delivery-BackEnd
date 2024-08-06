package com.fastDelivery.exception;

public class LoginException extends Exception {

    public LoginException() {
        super("L'email ou le mot de passe est incorrect");
    }
}
