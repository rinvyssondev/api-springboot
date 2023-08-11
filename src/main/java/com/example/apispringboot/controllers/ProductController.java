package com.example.apispringboot.controllers;

import com.example.apispringboot.dto.ProductRecordsDTO;
import com.example.apispringboot.models.ProductModel;
import com.example.apispringboot.services.ProductService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import java.util.UUID;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/products")
    public ResponseEntity<ProductModel> saveProduct(@RequestBody @Valid ProductRecordsDTO productRecordsDTO) {
        return productService.saveProduct(productRecordsDTO);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping("/products")
    public ResponseEntity<List<ProductModel>> getAllProducts(){
        return productService.getAllProducts();
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
    @GetMapping("/products/{id}")
    public ResponseEntity<Object> getOneProduct(@PathVariable(value = "id")UUID id){
        return productService.getOneProduct(id);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/products/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable(value = "id")UUID id, @RequestBody @Valid ProductRecordsDTO productRecordsDTO){
        return productService.updateProduct(id, productRecordsDTO);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/products/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable(value = "id") UUID id) {
        return productService.deleteProduct(id);
    }
}
