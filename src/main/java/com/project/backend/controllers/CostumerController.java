package com.project.backend.controllers;

import com.project.backend.entities.Costumer;
import com.project.backend.requests.CostumerRequest;
import com.project.backend.services.CostumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/client")
public class CostumerController {
    @Autowired
    private CostumerService costumerService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> postCostumer(@RequestBody CostumerRequest costumerRequest) {
        try {
            Costumer newCostumer = new Costumer(
                    costumerRequest.getName(),
                    costumerRequest.getLastname(),
                    costumerRequest.getDni()
            );
            return ResponseEntity.created(URI.create("")).body(costumerService.createCostumer(newCostumer));
        } catch(Exception e) {
            return ResponseEntity.internalServerError().body(e.getStackTrace());
        }
    }
    @GetMapping(value = "/read/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> readCostumer(@PathVariable(name = "id") long id) {
        Optional<Costumer> searchedClient = costumerService.readCostumer(id);
        System.out.println("1 ----------");
        if(searchedClient.isPresent()) {
            return ResponseEntity.of(searchedClient);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping(value = "/read/all", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> readAllCostumer() {
        return ResponseEntity.ok().body(costumerService.readAllCostumer());
    }
    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<?> deleteCostumer(@PathVariable(name = "id") long id) {
        costumerService.deleteCostumer(id);
        return ResponseEntity.ok().body("Client with ID:" + id + " deleted.");
    }
}
