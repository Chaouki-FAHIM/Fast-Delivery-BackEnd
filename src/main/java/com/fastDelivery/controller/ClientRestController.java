package com.fastDelivery.controller;

import com.fastDelivery.dto.request.ClientReqDTO;
import com.fastDelivery.dto.response.ClientResDTO;
import com.fastDelivery.exception.NotFoundIDException;
import com.fastDelivery.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController("client_controller")
@RequestMapping("/api/clients")
@CrossOrigin(origins = "http://localhost:3000")
public class ClientRestController implements IController<ClientReqDTO,Long> {

    @Autowired
    @Qualifier("client_service")
    private IService<ClientReqDTO, ClientResDTO, Long> clientService;

    @Override
    public ResponseEntity<?> create(ClientReqDTO client) {
        return null;
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
       try {
           return ResponseEntity.status(HttpStatus.OK).body(clientService.getById(id));
       } catch (NotFoundIDException e) {
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error",Map.of("error",Map.of("error",e.getMessage()))));
       } catch (Exception e) {
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("error",e.getMessage()));
       }
    }

    @Override
    @GetMapping
    public ResponseEntity<?> getAll(@RequestParam(defaultValue = "1") int pageNumber,@RequestParam(defaultValue = "15") int limitClient) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(clientService.getAll(pageNumber,limitClient));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("error",e.getMessage()));
        }
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody ClientReqDTO client,@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(clientService.update(client,id));
        } catch (NotFoundIDException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error",e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("error",e.getMessage()));
        }
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return null;
    }
}
