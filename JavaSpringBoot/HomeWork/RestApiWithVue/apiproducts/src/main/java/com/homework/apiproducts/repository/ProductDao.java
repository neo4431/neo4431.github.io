package com.homework.apiproducts.repository;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.homework.apiproducts.model.Product;

import org.springframework.stereotype.Repository;

@Repository
public class ProductDao extends Dao<Product> {
    public ProductDao(){
        collections.add(new Product(1L, "PC HP ProDesk 400 G7 MT (22F92PA)", "PC", 899.99F, 12, "pc.jpg"));
        collections.add(new Product(2L, "Tai nghe không dây Prolink Đen Đỏ", "Headphone", 21.99F, 34, "headphone.jpg"));
        collections.add(new Product(3L, "iPhone 12 Pro Max 256GB", "iphone", 1499.99F, 14, "iphone.jpg"));
    }
    @Override
    public List<Product> getAll() {
        // TODO Auto-generated method stub
        return collections;
    }

    @Override
    public Optional<Product> getById(Long id) {
        // TODO Auto-generated method stub
        return collections.stream().filter((ele) -> { return ele.getId() == id; }).findFirst();
    }

    @Override
    public void add(Product product) {
        // TODO Auto-generated method stub
        Long id;
        if(collections.isEmpty()){
            id = 1L;
        } else {
            Product lastProduct = collections.get(collections.size()-1);
            id = lastProduct.getId() + 1;
        }
        product.setId(id);
        collections.add(product);
    }

    @Override
    public void update(Product product) {
        // TODO Auto-generated method stub
        this.getById(product.getId()).ifPresent(existProduct -> {
            existProduct.setName(product.getName());
            existProduct.setCategory(product.getCategory());
            existProduct.setPrice(product.getPrice());
            existProduct.setImage(product.getImage());
            existProduct.setQuantity(product.getQuantity());
        });
    }

    @Override
    public void delete(Product product) {
        // TODO Auto-generated method stub
        this.getById(product.getId()).ifPresent(existProduct -> {
            collections.remove(existProduct);
        });
    }
    
    public List<Product> searchByKeyword(String keyword, String sort){
        // List sau khi search
        List<Product> products = collections
        .stream()
        .filter(product -> { 
            return product.getName().toLowerCase().contains(keyword.toLowerCase()) 
            || product.getCategory().toLowerCase().contains(keyword.toLowerCase());
        }).collect(Collectors.toList());
        // Kiểm tra điều kiện sort hiện tại
        if(sort.equals("asc")){
            return products
            .stream()
            .sorted(Comparator.comparing(Product::getPrice, (o1,o2)->{ return o1.compareTo(o2); }))
            .collect(Collectors.toList());
        } else if(sort.equals("desc")) {
            return products
            .stream()
            .sorted(Comparator.comparing(Product::getPrice, (o1,o2)->{ return o2.compareTo(o1); }))
            .collect(Collectors.toList());
        }
        return products;
    }
}