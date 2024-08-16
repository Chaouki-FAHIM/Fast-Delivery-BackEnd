package com.fastDelivery.exception;

public class NullRequestDataException extends Exception {

    public NullRequestDataException(String element) {
        super(element + " est vide ou null(e)");
    }
}
