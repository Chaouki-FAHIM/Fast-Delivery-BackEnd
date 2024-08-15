package com.fastDelivery.controller;

import com.fastDelivery.service.VilleAndBanqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController("ville_controller")
@RequestMapping("/api/data")
@CrossOrigin(origins = "http://localhost:3000")
public class VilleAndBanqueController {

    private final VilleAndBanqueService villeAndBanqueService;


    @Autowired
    public VilleAndBanqueController(VilleAndBanqueService villeAndBanqueService) {
        this.villeAndBanqueService = villeAndBanqueService;
    }

    @GetMapping("/villes")
    private ResponseEntity<?> getAllCities() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(villeAndBanqueService.getAllCities());

        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error reading JSON file cities");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/banques")
    private ResponseEntity<?> getAllBanks() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(villeAndBanqueService.getAllBanks());

        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error reading JSON file banks");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
