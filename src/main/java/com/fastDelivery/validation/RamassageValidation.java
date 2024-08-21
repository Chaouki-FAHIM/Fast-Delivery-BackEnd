package com.fastDelivery.validation;

import com.fastDelivery.dto.request.RamassageReqDTO;
import com.fastDelivery.dto.response.ColisResDTO;
import com.fastDelivery.exception.NotFoundIDException;
import com.fastDelivery.exception.NullRequestDataException;
import com.fastDelivery.service.IColisService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


import java.util.List;

@Component("ramassage_validation")
@RequiredArgsConstructor
public class RamassageValidation implements IValidation<RamassageReqDTO,Long> {


    @Autowired
    @Qualifier("colis_service")
    private final IColisService colisService;

    private void dataRamassageValidation(RamassageReqDTO request) throws NotFoundIDException {

        List<Long> listIdColis = request.getListIdColis();

        for (Long id : listIdColis) {
            colisService.getById(id);
        }
    }


    @Override
    public void toCreate(RamassageReqDTO ramassageReqDTO) throws NullRequestDataException, NotFoundIDException {
        dataValidation(ramassageReqDTO);
        dataRamassageValidation(ramassageReqDTO);
    }

    @Override
    public void toUpdate(RamassageReqDTO ramassageReqDTO, Long id) throws NullRequestDataException, NotFoundIDException {
        dataValidation(ramassageReqDTO);
        dataRamassageValidation(ramassageReqDTO);
    }
}
