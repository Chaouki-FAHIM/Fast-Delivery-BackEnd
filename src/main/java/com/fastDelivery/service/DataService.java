package com.fastDelivery.service;

import com.fastDelivery.enumerator.StatutColis;
import com.fastDelivery.enumerator.StatutRamassage;
import com.fastDelivery.model.Banque;
import com.fastDelivery.model.MetaData;
import com.fastDelivery.model.Ville;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("ville_service")
@Slf4j
public class DataService {

    public List<Ville> getAllCities() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ClassPathResource resource = new ClassPathResource("cities.json");
        return mapper.readValue(resource.getInputStream(), new TypeReference<List<Ville>>() {});
    }

    public List<Ville> getAllPopularCities() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ClassPathResource resource = new ClassPathResource("popular_cities.json");
        return mapper.readValue(resource.getInputStream(), new TypeReference<List<Ville>>() {});
    }

    public List<Banque> getAllBanks() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ClassPathResource resource = new ClassPathResource("banks.json");
        return mapper.readValue(resource.getInputStream(),  new TypeReference<List<Banque>>() {});

    }

    public List<String> getAllSatutRamassage() {

        List<StatutRamassage> statutRamassages = Arrays.asList(StatutRamassage.values());

        return statutRamassages.stream().map(StatutRamassage::getFormattedString).toList();
    }

    public List<String> getAllSatutColis() {

        List<StatutColis> statutColis = Arrays.asList(StatutColis.values());

        return statutColis.stream().map(StatutColis::getFormattedString).toList();
    }
}
