package com.fastDelivery.controller;

import com.fastDelivery.dto.request.ClientReqDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("client_controller")
@RequestMapping("/api/clients")
@CrossOrigin(origins = "http://localhost:3000")
public class ClientRestController implements IController<ClientReqDTO,Long> {

    @Override
    public ResponseEntity<?> create(ClientReqDTO client) {
        return null;
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return null;
    }

    @Override
    @GetMapping
    public ResponseEntity<?> getAll() {
        return null;
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody ClientReqDTO client,@PathVariable Long id) {
        return null;
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return null;
    }
}
