package com.fastDelivery.controller;

import com.fastDelivery.dto.request.ClientReqDTO;
import com.fastDelivery.exception.*;
import com.fastDelivery.service.AuthentificationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("auth_controller")
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthentificationRestController {

    private final AuthentificationService authentificationService;


    public AuthentificationRestController(AuthentificationService authentificationService) {
        this.authentificationService = authentificationService;
    }

    @GetMapping("/login")
    public ResponseEntity<?> login (@RequestParam String email, @RequestParam String password) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(authentificationService.login(email, password));
        } catch (LoginException e) {
            return ResponseEntity.status(401).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register (@RequestBody @Valid ClientReqDTO client) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(authentificationService.register(client));
        } catch (NullRequestDataException | NotEmailException | BadPasswordException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/verifyEmail")
    public ResponseEntity<?> verifyEmailInDB (@RequestParam String email) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(authentificationService.verifyEmailInDB(email));
        } catch (ExistEmailDBException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/sendOtp")
    public ResponseEntity<?> sendOtp(@RequestParam String email) {
        try {
            if (authentificationService.verifyEmailExists(email)) {
                String otp = authentificationService.generateOtp(email);
                authentificationService.sendOtpEmail(email, otp);
                return ResponseEntity.status(HttpStatus.OK).body("OTP sent to email: " + email);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email address does not exist.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/verifyOtp")
    public ResponseEntity<?> verifyOtp(@RequestParam String email, @RequestParam String otp) {
        try {
            boolean isValid = authentificationService.verifyOtp(email, otp);
            return isValid ? ResponseEntity.status(HttpStatus.OK).body("OTP verified successfully!")
                    : ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid OTP!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
