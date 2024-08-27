package com.fastDelivery.exception;

public class NotFoundIDException extends Exception {

    public NotFoundIDException(String element, Long id) {
<<<<<<< HEAD
        super(element+ " de l'id "+id+ " est introuvable");
=======
        super(element+ " par l'id "+id+ " est introuvable");
>>>>>>> cda643eaa56729a0317e3646aaca7c86d30b8179
    }
}
