package com.project.backend.services;

import com.project.backend.entities.Sell;
import com.project.backend.repositories.SellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class SellService {
    @Autowired
    private SellRepository sellRepository;

    public Sell createSell(Sell newSell) {
        return sellRepository.save(newSell);
    }

    public Optional<Sell> readSell(long id) {
        return sellRepository.findById(id);
    }

    public List<Sell> readAllSell() {
        return sellRepository.findAll();
    }

    public void deleteSell(long id) {
        sellRepository.deleteById(id);
    }
}
