package com.fastDelivery.service;


import com.fastDelivery.dto.request.ColisReqDTO;
import com.fastDelivery.dto.response.ColisResDTO;
import com.fastDelivery.exception.NotFoundIDException;

import java.util.Map;

public interface IColisService extends IService<ColisReqDTO, ColisResDTO,Long> {

    String changementStatut(String statut, Long id) throws NotFoundIDException;
    Map<String, Object> GetAllColisEnAttente(int pageNumber, int limitColis);
}
