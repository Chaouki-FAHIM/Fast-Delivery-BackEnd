package com.fastDelivery.controller;

import com.fastDelivery.dto.request.ColisReqDTO;
import com.fastDelivery.dto.request.RamassageReqDTO;
import org.springframework.http.ResponseEntity;

public interface IRamassageContoller extends IController<RamassageReqDTO,Long> {
    ResponseEntity<?> changementStatut (Long id);
}
