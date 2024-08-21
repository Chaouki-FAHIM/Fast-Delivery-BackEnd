package com.fastDelivery.controller;

import org.springframework.http.ResponseEntity;

public interface IController<DTO,ID> {

    ResponseEntity<?> create (DTO dto);
    ResponseEntity<?> getById (ID id);
    ResponseEntity<?> getAll (int pageNumber, int limitItem);
    ResponseEntity<?> update (DTO dto, ID id);
    ResponseEntity<?> delete (ID id);

}
