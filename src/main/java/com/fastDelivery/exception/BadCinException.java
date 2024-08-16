package com.fastDelivery.exception;

public class BadCinException extends Exception {
    public BadCinException() {
        super("Le CIN excepte juste 8 caractères");
    }
}
