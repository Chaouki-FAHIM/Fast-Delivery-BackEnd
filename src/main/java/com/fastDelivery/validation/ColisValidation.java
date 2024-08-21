package com.fastDelivery.validation;

import com.fastDelivery.dto.request.ColisReqDTO;
import com.fastDelivery.exception.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component("colis_validation")
@Slf4j
public class ColisValidation  implements IValidation<ColisReqDTO,Long> {


    private void dataColisValidation(ColisReqDTO colisReqDTO) throws NullRequestDataException, BadMontantException {

        // validation ville de ramassage
        if( colisReqDTO.getMontant() <= 0) {
            log.error("Le montant entré est invalide (supérieur strictement à 0 dhs");
            throw new BadMontantException();
        }

        // validation ville de ramassage
        if(!isExist(colisReqDTO.getVilleRamassage())) {
            log.error("La ville de ramassage est vide ou nulle");
            throw new NullRequestDataException("La ville de ramassage");
        }

    }
    @Override
    public void toCreate(ColisReqDTO colisReqDTO) throws NullRequestDataException, BadMontantException {

        dataValidation(colisReqDTO);
        dataColisValidation(colisReqDTO);
    }

    @Override
    public void toUpdate(ColisReqDTO colisReqDTO, Long id) throws NullRequestDataException, BadMontantException {

        dataValidation(colisReqDTO);
        dataColisValidation(colisReqDTO);
    }
}
