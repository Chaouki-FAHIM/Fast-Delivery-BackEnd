package com.fastDelivery.exception;

public class RededicationUserException extends Exception {

    public RededicationUserException(String element,String value) {
        super(element+ " avec la valeur ["+value+"] est déjà consommé");
    }

}
