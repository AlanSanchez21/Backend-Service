package com.project.backend.services;

import com.project.backend.entities.Product;
import com.project.backend.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(Product newProduct) {
        return productRepository.save(newProduct);
    }
    public Optional<Product> readProduct(long id) {
        return productRepository.findById(id);
    }
    public List<Product> readAllProduct() {
        return productRepository.findAll();
    }
    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }
}
