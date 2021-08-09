package com.homework.shopingcart.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Product implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -6201237877676650734L;
    
    private Long id;
    private String name;
    private String manufacturer;
    private Long price;
    private String photo;

    public Product(String name, String manufacturer, Long price, String photo){
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
        this.photo = photo;
    }
}