package com.fastDelivery.exception;

public class NotFoundIDException extends Exception {

    public NotFoundIDException(String element, Long id) {
        super(element+ " de l'id "+id+ " est introuvable");
    }
}
