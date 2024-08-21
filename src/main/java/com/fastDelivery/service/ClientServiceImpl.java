package com.fastDelivery.service;

import com.fastDelivery.dto.request.ClientReqDTO;
import com.fastDelivery.dto.response.ClientResDTO;
import com.fastDelivery.entities.Client;
import com.fastDelivery.exception.*;
import com.fastDelivery.mapper.IMapper;
import com.fastDelivery.model.MetaData;
import com.fastDelivery.repo.ClientRepository;
import com.fastDelivery.validation.IValidation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service("client_service")
@Slf4j
@RequiredArgsConstructor
public class ClientServiceImpl implements IService<ClientReqDTO, ClientResDTO,Long>{

    @Autowired
    @Qualifier("client_validation")
    private IValidation<ClientReqDTO,Long> clientValidation;

    @Autowired
    @Qualifier("client_repo")
    private ClientRepository clientRepository;

    @Autowired
    @Qualifier("client_mapper")
    private IMapper<Client, ClientResDTO, ClientReqDTO> clientMapper;

    @Override
    public ClientResDTO create(ClientReqDTO clientReqDTO)  {
        return null;
    }

    private Client recieveClient(long id) throws NotFoundIDException {

        Client client = clientRepository.findById(id).orElse(null);

        if(client == null) {
            log.error("Le client avec l'id {} est introuvable",id);
            throw new NotFoundIDException("Le client", id);
        }
        return client;
    }

    @Override
    public ClientResDTO getById(Long id) throws NotFoundIDException {

        log.info("Start : Get Client by id "+id);
        Client client = recieveClient(id);

        log.info("End : Get Client by id "+id);
        return clientMapper.fromModelToRes(client);
    }

    @Override
    public Map<String, Object> getAll(int pageNumber, int limitClient) {

        log.info("Start  : Get all Client ");
        Pageable pageable = PageRequest.of(pageNumber - 1, limitClient);

        Page<Client> clients = clientRepository.findAll(pageable);

        MetaData metaData = MetaData.builder()
                .totalCount((int) clients.getTotalElements())
                .page(pageNumber)
                .perPage(limitClient)
                .build();

        Map<String, Object> response = new HashMap<>();
        response.put("metadata", metaData);

        List<ClientResDTO> clientResDTOList = clients.stream().map(clientMapper::fromModelToRes).toList();

        if(clientResDTOList.isEmpty()) response.put("data",null);
        else response.put("data",clientResDTOList);

        log.info("End : Get all Client ");
        return response;
    }

    @Override
    public ClientResDTO update(ClientReqDTO clientReqDTO, Long id) throws NullRequestDataException, BadPasswordException, NotEmailException, NotFoundIDException, BadCinException, RededicationUserException, BadMontantException {

        log.info("Start : Update Client by id "+id);

        // validation data of client for update
        clientValidation.toUpdate(clientReqDTO,id);

        // validation id
        Client client = recieveClient(id);

        // process to update
        client.setNom(clientReqDTO.getNom());
        client.setPrenom(clientReqDTO.getPrenom());
        client.setNumeroTelephone(clientReqDTO.getNumeroTelephone());
        client.setEmail(clientReqDTO.getEmail());
        client.setVille(clientReqDTO.getVille());
        client.setAdresseLocale(clientReqDTO.getAdresseLocale());
        client.setCIN(clientReqDTO.getCin());
        client.setRib(clientReqDTO.getRib());
        client.setBanque(clientReqDTO.getDenominationBanque());

        // save update in database
        clientRepository.save(client);

        log.info("End : Update Client by id "+id);

        return clientMapper.fromModelToRes(client);
    }

    @Override
    public void delete(Long id) throws NotFoundIDException {

        log.info("Start : Delete Client by id "+id);


        clientRepository.delete(recieveClient(id));

        log.info("End : Delete Client by id "+id);
    }
}
