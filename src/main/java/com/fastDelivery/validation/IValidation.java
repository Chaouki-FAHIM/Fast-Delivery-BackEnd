package com.fastDelivery.validation;

<<<<<<< HEAD

import com.fastDelivery.dto.request.PersonneReqDTO;
import com.fastDelivery.exception.*;


public interface IValidation<Req,ID> {

    default boolean isExist(String value) {
        return value != null && value != "";
    }
    default void dataValidation(PersonneReqDTO personneReqDTO) throws NullRequestDataException {
        
        // validation first name
        if(!isExist(personneReqDTO.getNom())) {
            throw new NullRequestDataException("Le nom");
        }

        // validation last name
        if(!isExist(personneReqDTO.getPrenom())) {
            throw new NullRequestDataException("Le prénom");
        }

        // validation phone nuumber
        if(!isExist(personneReqDTO.getNumeroTelephone())) {
            throw new NullRequestDataException("Le numéro de téléphone");
        }

        // validation city
        if(!isExist(personneReqDTO.getVille())) {
            throw new NullRequestDataException("La ville");
        }

        // validation local address
        if(!isExist(personneReqDTO.getAdresseLocale())) {
            throw new NullRequestDataException("L'adresse locale");
        }
    }

    void toCreate(Req object) throws BadPasswordException, NullRequestDataException, NotEmailException, BadCinException, RededicationUserException, BadMontantException, NotFoundIDException;
    void toUpdate(Req object,ID id) throws NullRequestDataException, NotEmailException, BadCinException, RededicationUserException, BadMontantException, NotFoundIDException;
=======
import com.fastDelivery.exception.BadCinException;
import com.fastDelivery.exception.BadPasswordException;
import com.fastDelivery.exception.NotEmailException;
import com.fastDelivery.exception.NullRequestDataException;

public interface IValidation<TD> {
    void toCreate(TD object) throws BadPasswordException, NullRequestDataException, NotEmailException, BadCinException;
    void toUpdate(TD object) throws NullRequestDataException, NotEmailException, BadCinException;
>>>>>>> cda643eaa56729a0317e3646aaca7c86d30b8179
}
