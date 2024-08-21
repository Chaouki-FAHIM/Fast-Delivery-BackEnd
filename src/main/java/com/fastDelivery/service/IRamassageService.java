package com.fastDelivery.service;

import com.fastDelivery.dto.request.RamassageReqDTO;
import com.fastDelivery.dto.response.RamassageResDTO;
import com.fastDelivery.exception.NotFoundIDException;

public interface IRamassageService extends IService<RamassageReqDTO, RamassageResDTO,Long> {

    String changementStatut(Long id) throws NotFoundIDException;
}

