package com.homework.shopingcart.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderLine implements Serializable{
    private static final long serialVersionUID = -3239063316084655346L;

    private Product product;
    private int count;

    public void increase(){
        this.count += 1;
    }

    public void decrease(){
        this.count = this.count - 1;
    }
}