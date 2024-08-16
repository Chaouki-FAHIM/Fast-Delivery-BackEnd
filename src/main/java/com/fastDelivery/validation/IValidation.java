package com.fastDelivery.validation;

import com.fastDelivery.exception.BadCinException;
import com.fastDelivery.exception.BadPasswordException;
import com.fastDelivery.exception.NotEmailException;
import com.fastDelivery.exception.NullRequestDataException;

public interface IValidation<TD> {
    void toCreate(TD object) throws BadPasswordException, NullRequestDataException, NotEmailException, BadCinException;
    void toUpdate(TD object) throws NullRequestDataException, NotEmailException, BadCinException;
}
