package com.fastDelivery.exception;

public class BadPasswordException extends Exception {

    public BadPasswordException() {
        super("Mot de passe est invalide");
    }
}
