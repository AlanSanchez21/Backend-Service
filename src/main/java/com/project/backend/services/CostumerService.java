package com.project.backend.services;

import com.project.backend.entities.Costumer;
import com.project.backend.repositories.CostumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
