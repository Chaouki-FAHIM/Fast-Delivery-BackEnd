package com.fastDelivery.exception;

public class NonAutoriserException extends Exception {
    public NonAutoriserException() {
        super("Le colis en statut est non en attente, alors l'opération de mise à jour non autorisé");
    }
}
