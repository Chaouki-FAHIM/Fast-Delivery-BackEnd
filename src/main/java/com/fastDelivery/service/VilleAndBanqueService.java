package com.fastDelivery.service;

import com.fastDelivery.model.Banque;
import com.fastDelivery.model.Ville;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service("ville_service")
@Slf4j
public class VilleAndBanqueService {

    public List<Ville> getAllCities() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ClassPathResource resource = new ClassPathResource("cities.json");
        return mapper.readValue(resource.getInputStream(), new TypeReference<List<Ville>>() {});
    }

    public List<Banque> getAllBanks() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ClassPathResource resource = new ClassPathResource("banks.json");
        return mapper.readValue(resource.getInputStream(),  new TypeReference<List<Banque>>() {});

    }
}
