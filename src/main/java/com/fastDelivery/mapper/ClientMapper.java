package com.fastDelivery.mapper;

import com.fastDelivery.dto.request.ClientReqDTO;
import com.fastDelivery.dto.response.ClientResDTO;
import com.fastDelivery.entities.Client;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component("client_mapper")
public class ClientMapper implements IMapper<Client, ClientResDTO, ClientReqDTO> {

    @Override
    public Client fromReqToModel(ClientReqDTO clientReqDTO) {
        return new Client(
                clientReqDTO.getNom(),
                clientReqDTO.getPrenom(),
                clientReqDTO.getVille(),
                clientReqDTO.getAdresseLocale(),
                clientReqDTO.getNumeroTelephone(),
                clientReqDTO.getEmail(),
                clientReqDTO.getPassword(),
<<<<<<< HEAD
=======
                clientReqDTO.getNom().toLowerCase()+ "_"+clientReqDTO.getPrenom().toLowerCase(),
>>>>>>> cda643eaa56729a0317e3646aaca7c86d30b8179
                clientReqDTO.getCin(),
                clientReqDTO.getRib(),
                clientReqDTO.getDenominationBanque()
        );
    }

    @Override
    public ClientResDTO fromModelToRes(Client client) {
        return  new ClientResDTO(
                client.getIdPersonne(),
<<<<<<< HEAD
=======
                client.getEmail(),
>>>>>>> cda643eaa56729a0317e3646aaca7c86d30b8179
                client.getDateCreation(),
                client.getNom(),
                client.getPrenom(),
                client.getVille(),
                client.getAdresseLocale(),
                client.getNumeroTelephone(),
<<<<<<< HEAD
                client.getEmail(),
=======
>>>>>>> cda643eaa56729a0317e3646aaca7c86d30b8179
                client.getCIN(),
                client.getRib(),
                client.getBanque()
        );
    }
}
