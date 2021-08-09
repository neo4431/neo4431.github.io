package com.homework.apiproducts.controller;

import java.util.List;
import java.util.Optional;

import com.homework.apiproducts.model.Product;
import com.homework.apiproducts.repository.ProductDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8080")
public class ProductController {
    @Autowired
    private ProductDao productDao;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAll(
        @RequestParam(required = false) String keyword,
        @RequestParam(required = false) String sort
        ) {

        if (keyword != null) {
            return ResponseEntity.ok(productDao.searchByKeyword(keyword, sort));
        }

        return ResponseEntity.ok(productDao.getAll());
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Optional<Product>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(productDao.getById(id));
    }
}