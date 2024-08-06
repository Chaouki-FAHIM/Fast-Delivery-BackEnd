package com.fastDelivery.service;

import com.fastDelivery.dto.request.ClientReqDTO;
import com.fastDelivery.dto.response.ClientResDTO;
import com.fastDelivery.dto.response.LoginResDTO;
import com.fastDelivery.exception.LoginException;
import com.fastDelivery.entities.Client;
import com.fastDelivery.mapper.ClientMapper;
import com.fastDelivery.repo.ClientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service("auth_service")
@Slf4j
public class AuthentificationService {

    @Autowired
    @Qualifier("client_repo")
    private ClientRepository clientRepository;

    @Autowired
    @Qualifier("client_mapper")
    private ClientMapper clientMapper;

    @Autowired
    private JavaMailSender javaMailSender;

    private Map<String, String> otpStorage = new HashMap<>();

    public LoginResDTO login(String email, String password) throws LoginException {
        Client client = clientRepository.findByEmailAndPassword(email,password);

        if (client == null) {
            log.error("Client est non trouvé pour le traitement de login");
            throw new LoginException();
        }

        return LoginResDTO.builder()
                .username(client.getUsername())
                .build();
    }

    public ClientResDTO register(ClientReqDTO clientReqDTO) {

        Client client = clientMapper.fromReqToModel(clientReqDTO);

        clientRepository.save(client);

        return clientMapper.froModelToRes(client);
    }

    public boolean verifyEmailExists(String email) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(email);
            message.setSubject("Email Verification");
            message.setText("This is a verification email.");
            javaMailSender.send(message);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String generateOtp(String email) {
        String otp = String.valueOf(new Random().nextInt(900000) + 100000);
        otpStorage.put(email, otp);
        return otp;
    }

    public void sendOtpEmail(String email, String otp) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Your OTP Code");
        message.setText("Your OTP code is: " + otp);
        javaMailSender.send(message);
    }

    public boolean verifyOtp(String email, String otp) {
        return otpStorage.containsKey(email) && otpStorage.get(email).equals(otp);
    }
}
