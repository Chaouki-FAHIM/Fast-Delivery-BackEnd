package com.fastDelivery.validation;

import com.fastDelivery.dto.request.ClientReqDTO;
<<<<<<< HEAD
import com.fastDelivery.entities.Personne;
import com.fastDelivery.exception.*;
import com.fastDelivery.repo.PersonneRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
=======
import com.fastDelivery.exception.BadCinException;
import com.fastDelivery.exception.BadPasswordException;
import com.fastDelivery.exception.NotEmailException;
import com.fastDelivery.exception.NullRequestDataException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

>>>>>>> cda643eaa56729a0317e3646aaca7c86d30b8179
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component("client_validation")
@Slf4j
<<<<<<< HEAD
public class ClientValidation implements IValidation<ClientReqDTO,Long> {

    @Autowired
    @Qualifier("personne_repo")
    private PersonneRepository personneRepository;

=======
public class ClientValidation implements IValidation<ClientReqDTO> {

    private boolean isExist(String value) {
        return value != null && value != "";
    }
>>>>>>> cda643eaa56729a0317e3646aaca7c86d30b8179

    public boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

<<<<<<< HEAD
    private void dataClientValidation(ClientReqDTO clientReqDTO, boolean isUpdate, long clientReqId) throws NullRequestDataException, NotEmailException, BadCinException, RededicationUserException {

        // create a list of stock result client
        List< Personne > personnes =  new ArrayList<>();

        // validation last name and first name in database
        if( isUpdate )
            personnes= personneRepository.findByNomIgnoreCaseAndPrenomIgnoreCaseAndIdPersonneNot(clientReqDTO.getNom(),clientReqDTO.getPrenom(), clientReqId);
        else
            personnes= personneRepository.findByNomIgnoreCaseAndPrenomIgnoreCase(clientReqDTO.getNom(),clientReqDTO.getPrenom());

        if( !personnes.isEmpty() ) {
            String fullNameValue = clientReqDTO.getNom() + " " + clientReqDTO.getPrenom();
            log.error("Found academic advisor with full name: {}", fullNameValue);
            throw new RededicationUserException("full name",fullNameValue);
=======
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
>>>>>>> cda643eaa56729a0317e3646aaca7c86d30b8179
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

<<<<<<< HEAD
=======
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

>>>>>>> cda643eaa56729a0317e3646aaca7c86d30b8179
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
<<<<<<< HEAD
    public void toCreate(ClientReqDTO clientReqDTO) throws BadPasswordException, NullRequestDataException, NotEmailException, BadCinException, RededicationUserException {

        dataValidation(clientReqDTO);
        dataClientValidation(clientReqDTO,false,0L);
=======
    public void toCreate(ClientReqDTO clientReqDTO) throws BadPasswordException, NullRequestDataException, NotEmailException, BadCinException {

        dataValidation(clientReqDTO);
>>>>>>> cda643eaa56729a0317e3646aaca7c86d30b8179

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
<<<<<<< HEAD
    public void toUpdate(ClientReqDTO clientReqDTO, Long clientReqId) throws NullRequestDataException, NotEmailException, BadCinException, RededicationUserException {
        dataValidation(clientReqDTO);
        dataClientValidation(clientReqDTO,true, clientReqId);
=======
    public void toUpdate(ClientReqDTO clientReqDTO) throws NullRequestDataException, NotEmailException, BadCinException {
        dataValidation(clientReqDTO);
>>>>>>> cda643eaa56729a0317e3646aaca7c86d30b8179
    }
}
