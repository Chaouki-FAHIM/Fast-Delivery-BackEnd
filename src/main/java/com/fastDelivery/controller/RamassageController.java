package com.fastDelivery.controller;


import com.fastDelivery.dto.request.RamassageReqDTO;
import com.fastDelivery.exception.*;
import com.fastDelivery.service.IRamassageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController("ramassage_controller")
@RequestMapping("/api/ramassages")
@RequiredArgsConstructor
public class RamassageController implements IRamassageContoller {


    @Autowired
    @Qualifier("ramassage_service")
    private final IRamassageService ramassageService;

    @Override
    @PatchMapping("/statut/{id}")   // /api/colis/4
    public ResponseEntity<?> changementStatut(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(ramassageService.getById(id));
        } catch (NotFoundIDException | IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error",e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("error",e.getMessage()));
        }
    }

    @Override
    @PostMapping
    public ResponseEntity<?> create(@RequestBody RamassageReqDTO ramassageReqDTO) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(ramassageService.create(ramassageReqDTO));
        } catch (NullRequestDataException | NotFoundIDException  e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error",e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("error",e.getMessage()));
        }
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(ramassageService.getById(id));
        } catch (NotFoundIDException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error",e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("error",e.getMessage()));
        }
    }

    @Override
    @GetMapping
    public ResponseEntity<?> getAll(@RequestParam(defaultValue = "1") int pageNumber,@RequestParam(defaultValue = "10") int limitRamassage) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(ramassageService.getAll(pageNumber,limitRamassage));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("error",e.getMessage()));
        }
    }

    @Override
    public ResponseEntity<?> update(@RequestBody RamassageReqDTO ramassageReqDTO,@PathVariable Long id) {
        return null;
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            ramassageService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body(Map.of("success","Bonne supression de ramassage"));
        } catch (NotFoundIDException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("error",e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("error",e.getMessage()));
        }
    }
}
