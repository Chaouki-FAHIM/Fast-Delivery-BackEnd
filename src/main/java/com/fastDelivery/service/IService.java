package com.fastDelivery.service;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IService <Req,Res,ID>{

    Res create (Req req);
    Res getById (ID id);
    List<Res> getAll ();
    Res update (Req req, ID id);
    void delete (ID id);
}
