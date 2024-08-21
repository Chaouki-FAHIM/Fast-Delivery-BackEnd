package com.fastDelivery.service;

import com.fastDelivery.dto.request.ClientReqDTO;
import com.fastDelivery.dto.response.ClientResDTO;
import com.fastDelivery.dto.response.LoginResDTO;
import com.fastDelivery.entities.Admin;
import com.fastDelivery.exception.*;
import com.fastDelivery.entities.Client;
import com.fastDelivery.mapper.ClientMapper;
import com.fastDelivery.repo.AdminRepository;
import com.fastDelivery.repo.ClientRepository;
import com.fastDelivery.validation.IValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    @Qualifier("client_validation")
    private IValidation<ClientReqDTO,Long> clientValidation;

    @Autowired
    @Qualifier("admin_repo")
    private  AdminRepository adminRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    private Map<String, String> otpStorage = new HashMap<>();

    public LoginResDTO login(String email, String password) throws LoginException {
        Client client = clientRepository.findByEmailAndPassword(email,password);

        Admin admin = adminRepository.findByEmailAndPassword(email,password);

        if (client == null && admin == null) {
            log.error("User est non trouvé pour le traitement de login");
            throw new LoginException();
        }

        if(client != null)
            return LoginResDTO.builder()
                    .username(client.getUsername())
                    .role(client.getRole())
                    .build();

        return LoginResDTO.builder()
                .username(admin.getUsername())
                .role(admin.getRole())
                .build();
    }

    public ClientResDTO register(ClientReqDTO clientReqDTO) throws NullRequestDataException, NotEmailException, BadPasswordException, BadCinException, RededicationUserException, BadMontantException, NotFoundIDException {

        clientValidation.toCreate(clientReqDTO);

        Client client = clientMapper.fromReqToModel(clientReqDTO);

        clientRepository.save(client);

        return clientMapper.fromModelToRes(client);
    }

    public boolean verifyEmailInDB(String email) throws ExistEmailDBException {
        List<Client> client = clientRepository.findByEmailIgnoreCase(email);
        if (!client.isEmpty()) {
            log.error("Email est déjà consomé ");
            throw new ExistEmailDBException();
        }
        return true;
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
