package com.project.backend.repositories;

import com.project.backend.entities.Product;
import com.project.backend.requests.ProductInSellRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Object> findById(List<ProductInSellRequest> quantity);
}
