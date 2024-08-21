package com.fastDelivery.exception;

public class BadMontantException extends Exception {

    public BadMontantException() {
        super("Le montant entré est invalide (supérieur strictement à 0 dhs)");
    }
}
