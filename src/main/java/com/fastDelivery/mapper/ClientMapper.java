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
        return Client.builder()
                .email(clientReqDTO.getEmail())
                .username(clientReqDTO.getNom().toLowerCase()+"_"+clientReqDTO.getPrenom().toLowerCase())
                .password(clientReqDTO.getPassword())
                .nom(clientReqDTO.getNom())
                .prenom(clientReqDTO.getPrenom())
                .ville(clientReqDTO.getVille())
                .CIN(clientReqDTO.getCin())
                .numeroTelephone(clientReqDTO.getNumeroTelephone())
                .dateCreation(new Date())
                .rib(clientReqDTO.getRib())
                .banque(clientReqDTO.getDenominationBanque())
                .build();
    }

    @Override
    public ClientResDTO froModelToRes(Client client) {
        return ClientResDTO.builder()
                .idClient(client.getIdClient())
                .emailClient(client.getEmail())
                .nom(client.getNom())
                .prenom(client.getPrenom())
                .ville(client.getVille())
                .cin(client.getCIN())
                .numeroTelephone(client.getNumeroTelephone())
                .dateCreationClient(client.getDateCreation())
                .rib(client.getRib())
                .denominationBanque(client.getBanque())
                .build();
    }
}
