package com.project.backend.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.backend.entities.Costumer;
import com.project.backend.repositories.CostumerRepository;
import com.project.backend.requests.CostumerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class CostumerService {
    @Autowired
    private CostumerRepository costumerRepository;

    public Costumer createCostumer(Costumer newCostumer) {
        return costumerRepository.save(newCostumer);
    }

    public Optional<Costumer> readCostumer(long id) {
        return costumerRepository.findById(id);
    }

    public List<Costumer> readAllCostumer() {
        return costumerRepository.findAll();
    }

    public void deleteCostumer(long id) {
        costumerRepository.deleteById(id);
    }

    public Costumer postCostumer(CostumerRequest costumerRequest) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        final String url = "https://localhost:8081/costumer";
        String response = restTemplate.postForObject(url, costumerRequest, String.class);

        final ObjectMapper customMapper = new ObjectMapper();
        final Costumer costumerResponse = customMapper.readValue(response, Costumer.class);

        return costumerResponse;
    }
}
