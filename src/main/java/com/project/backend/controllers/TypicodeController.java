package com.project.backend.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.project.backend.entities.Costumer;
import com.project.backend.requests.CostumerRequest;
import com.project.backend.services.CostumerService;
import com.project.backend.services.TypicodeRestApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/typicode")
public class TypicodeController {
    @Autowired
    private TypicodeRestApiService typicodeRestApiService;

    @GetMapping(value = "users", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getUsers() throws JsonProcessingException {
        return ResponseEntity.ok(typicodeRestApiService.getUsers());
    }
}
