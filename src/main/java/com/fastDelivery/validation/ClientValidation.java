package com.fastDelivery.validation;

import com.fastDelivery.dto.request.ClientReqDTO;
import com.fastDelivery.exception.BadCinException;
import com.fastDelivery.exception.BadPasswordException;
import com.fastDelivery.exception.NotEmailException;
import com.fastDelivery.exception.NullRequestDataException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component("client_validation")
@Slf4j
public class ClientValidation implements IValidation<ClientReqDTO> {

    private boolean isExist(String value) {
        return value != null && value != "";
    }

    public boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private void dataValidation(ClientReqDTO clientReqDTO) throws NullRequestDataException, NotEmailException, BadCinException {

        // validation first name
        if(!isExist(clientReqDTO.getNom())) {
            log.error("Le nom est vide ou null");
            throw new NullRequestDataException("Le nom");
        }

        // validation last name
        if(!isExist(clientReqDTO.getPrenom())) {
            log.error("Le prénom est vide ou null");
            throw new NullRequestDataException("Le prénom");
        }

        // validation email
        if(!isExist(clientReqDTO.getEmail())) {
            log.error("L'email est vide ou nulle");
            throw new NullRequestDataException("L'email");
        }

        if(!isValidEmail(clientReqDTO.getEmail())) {
            log.error("La format d'email est invalide");
            throw new NotEmailException();
        }

        // validation phone nuumber
        if(!isExist(clientReqDTO.getNumeroTelephone())) {
            log.error("Le numéro de téléphone est vide ou nulle");
            throw new NullRequestDataException("Le numéro de téléphone");
        }

        // validation city
        if(!isExist(clientReqDTO.getVille())) {
            log.error("La ville est vide ou nulle");
            throw new NullRequestDataException("La ville");
        }

        // validation local address
        if(!isExist(clientReqDTO.getAdresseLocale())) {
            log.error("L'adresse locale est vide ou nulle");
            throw new NullRequestDataException("L'adresse locale");
        }

        // validation cin
        if(!isExist(clientReqDTO.getCin())) {
            log.error("Le CIN est vide ou nulle");
            throw new NullRequestDataException("Le CIN");
        }

        if(clientReqDTO.getCin().length() !=8)  {
            log.error("Le CIN excepte juste 8 caractères");
            throw new BadCinException();
        }

        // validation RIB
        if(!isExist(clientReqDTO.getRib())) {
            log.error("Le RIB est vide ou nulle");
            throw new NullRequestDataException("Le RIB");
        }

        // validation bank name
        if(!isExist(clientReqDTO.getDenominationBanque())) {
            log.error("La denomination banquaire est vide ou nulle");
            throw new NullRequestDataException("La denomination banquaire");
        }
    }

    @Override
    public void toCreate(ClientReqDTO clientReqDTO) throws BadPasswordException, NullRequestDataException, NotEmailException, BadCinException {

        dataValidation(clientReqDTO);

        // validation password
        if(!isExist(clientReqDTO.getPassword())) {
            log.error("Le mot de passe est vide ou null");
            throw new NullRequestDataException("Le mot de passe");
        }

        if(clientReqDTO.getPassword().length() < 8) {
            log.error("Le mot de passe est moins de 8 charactère");
            throw new BadPasswordException();
        }
    }

    @Override
    public void toUpdate(ClientReqDTO clientReqDTO) throws NullRequestDataException, NotEmailException, BadCinException {
        dataValidation(clientReqDTO);
    }
}
