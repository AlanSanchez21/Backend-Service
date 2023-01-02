package com.project.backend.controllers;

import com.project.backend.entities.Sell;
import com.project.backend.requests.SellRequest;
import com.project.backend.services.SellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/sell")
public class SellController {
    @Autowired
    private SellService sellService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> postSell(@RequestBody SellRequest sellRequest) {
        try {
            Sell newSell = new Sell(
                    sellRequest.getName(),
                    sellRequest.getQuantity(),
                    sellRequest.getTotalPrice()
            );
            return ResponseEntity.created(URI.create("")).body(sellService.createSell(newSell));
        } catch(Exception e) {
            return ResponseEntity.internalServerError().body(e.getStackTrace());
        }
    }

    @GetMapping(value = "/read/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> readSell(@PathVariable(name = "id")long id) {
        Optional<Sell> searchedSell = sellService.readSell(id);
        System.out.println("1 ----------");
        if (searchedSell.isPresent()) {
            return ResponseEntity.of(searchedSell);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "/read/all", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> readAllSell() {
        return ResponseEntity.ok().body(sellService.readAllSell());
    }

    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<?> deleteSell(@PathVariable(name = "id")long id) {
        sellService.deleteSell(id);
        return ResponseEntity.ok().body("Sell with ID:" + id + " deleted.");
    }
}
