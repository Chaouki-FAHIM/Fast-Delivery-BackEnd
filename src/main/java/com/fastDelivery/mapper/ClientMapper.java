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
                clientReqDTO.getNom().toLowerCase()+ "_"+clientReqDTO.getPrenom().toLowerCase(),
                clientReqDTO.getCin(),
                clientReqDTO.getRib(),
                clientReqDTO.getDenominationBanque()
        );
    }

    @Override
    public ClientResDTO fromModelToRes(Client client) {
        return  new ClientResDTO(
                client.getIdPersonne(),
                client.getEmail(),
                client.getDateCreation(),
                client.getNom(),
                client.getPrenom(),
                client.getVille(),
                client.getAdresseLocale(),
                client.getNumeroTelephone(),
                client.getCIN(),
                client.getRib(),
                client.getBanque()
        );
    }
}
