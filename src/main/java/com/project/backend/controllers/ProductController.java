package com.project.backend.controllers;

import com.project.backend.entities.Product;
import com.project.backend.requests.ProductRequest;
import com.project.backend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> postProduct(@RequestBody ProductRequest productRequest) {
        try {
            Product newProduct = new Product(
                    productRequest.getName(),
                    productRequest.getCode(),
                    productRequest.getPrice()
            );
            return ResponseEntity.created(URI.create("")).body(productService.createProduct(newProduct));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getStackTrace());
        }
    }
    @GetMapping(value = "/read/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> readProduct(@PathVariable(name = "id")long id) {
        Optional<Product> searchedProduct = productService.readProduct(id);
        System.out.println("1 ----------");
        if (searchedProduct.isPresent()) {
            return ResponseEntity.of(searchedProduct);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping(value = "/read/all", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> readAllProduct() {
        return ResponseEntity.ok().body(productService.readAllProduct());
    }
    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable(name = "id")long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok().body("Product with ID:" + id + " deleted.");
    }
}
