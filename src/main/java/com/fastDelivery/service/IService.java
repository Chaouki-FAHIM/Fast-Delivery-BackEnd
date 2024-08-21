package com.fastDelivery.service;

import com.fastDelivery.exception.*;

import java.util.Map;

public interface IService <Req,Res,ID>{

    Res create (Req req) throws NullRequestDataException, BadMontantException, BadPasswordException, RededicationUserException, BadCinException, NotEmailException, NotFoundIDException;
    Res getById (ID id) throws NotFoundIDException;
    Map<String, Object> getAll (int pageNumber, int limitItem);
    Res update (Req req, ID id) throws NullRequestDataException, BadPasswordException, NotEmailException, NotFoundIDException, BadCinException, RededicationUserException, BadMontantException, NonAutoriserException;
    void delete (ID id) throws NotFoundIDException;
}
