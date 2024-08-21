package com.fastDelivery.controller;

import com.fastDelivery.service.DataService;
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
public class DataController {

    private final DataService dataService;


    @Autowired
    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping("/villes")
    private ResponseEntity<?> getAllCities() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(dataService.getAllCities());

        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error reading JSON file cities");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/populaires-villes")
    private ResponseEntity<?> getAllPopularCities() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(dataService.getAllPopularCities());

        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error reading JSON file popular cities");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/banques")
    private ResponseEntity<?> getAllBanks() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(dataService.getAllBanks());

        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error reading JSON file banks");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/statuts-ramassage")
    private ResponseEntity<?> getAllStatutsRamassage() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(dataService.getAllSatutRamassage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/statuts-colis")
    private ResponseEntity<?> getAllStatutsColis() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(dataService.getAllSatutColis());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
