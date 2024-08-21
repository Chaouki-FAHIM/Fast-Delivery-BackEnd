package com.fastDelivery.controller;

import com.fastDelivery.dto.request.ColisReqDTO;
import org.springframework.http.ResponseEntity;

public interface IColisContoller extends IController<ColisReqDTO,Long> {

    ResponseEntity<?> changementStatut (String statut, Long id);
    ResponseEntity<?> GetAllColisEnAttente(int pageNumber, int limitColis);
}
