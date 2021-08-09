package com.homework.shopingcart.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.homework.shopingcart.model.Product;

import org.springframework.stereotype.Repository;

@Repository
public class ProducRepository {
    private List<Product> products;
    private Long nextId;

    public ProducRepository(){
        products = new ArrayList<>();
        nextId = 1L;

        initData();
    }

    public Long createProduct(Product product){
        product.setId(nextId);
        nextId += 1;
        products.add(product);
        return nextId;
    }

    public void initData(){
        createProduct(new Product("PC HP ProDesk 400 G7 MT (22F92PA)", "HP", 17840000L, "pc.jpg"));
        createProduct(new Product("Laptop Dell Vostro 13 5301 V3I7129W", "Dell", 26190000L, "laptop.jpg"));
        createProduct(new Product("Điện Thoại Di Động iPhone 12 Pro Max 512GB Graphite MGDG3VN/A", "Apple", 37490000L, "iphone.jpg"));
        createProduct(new Product("TAI NGHE KHÔNG DÂY PROLINK PHB6003E ĐEN ĐỎ", "Prolink", 499000L, "headphone.jpg"));
    }

    public List<Product> findAll(){
        return products;
    }

    public Optional<Product> findById(Long id){
        return products.stream().filter( ele -> ele.getId() == id).findFirst();
    }
}