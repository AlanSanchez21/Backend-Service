package com.project.backend.services;

import aj.org.objectweb.asm.TypeReference;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.backend.entities.UserTypicode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class TypicodeRestApiService {

    public List<String>  getUsers() throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        final String url = "https://localhost:8081/costumer";
        List<String> response = restTemplate.getForObject(url, List.class);
        return response;
    }
}
