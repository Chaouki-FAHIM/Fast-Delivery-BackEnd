package com.fastDelivery.exception;

public class NotEmailException extends Exception {

    public NotEmailException() {
        super("La format d'email est invalide");
    }
}
