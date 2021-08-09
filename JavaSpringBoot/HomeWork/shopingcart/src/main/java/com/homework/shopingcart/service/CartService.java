package com.homework.shopingcart.service;

import java.util.HashMap;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import com.homework.shopingcart.model.Cart;
import com.homework.shopingcart.model.OrderLine;
import com.homework.shopingcart.model.Product;
import com.homework.shopingcart.repository.ProducRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    @Autowired
    ProducRepository productRepo;
  
  public void addToCart(Long id,  HttpSession session) {
    HashMap<Long, OrderLine> cart;

    var rawCart = session.getAttribute("CART");

    if (rawCart instanceof HashMap) {
      cart = (HashMap<Long, OrderLine>) rawCart;      
    } else {
      cart = new HashMap<>(); 
    }

    Optional<Product> product = productRepo.findById(id);
    if (product.isPresent()) {
      OrderLine orderLine = cart.get(id);
      if (orderLine == null) {
        cart.put(id, new OrderLine(product.get(), 1));
      } else {
        orderLine.increase();
        cart.put(id, orderLine);
      }
    }

    session.setAttribute("CART", cart);
  }

  public void decreaseToCart(Long id,  HttpSession session) {
    HashMap<Long, OrderLine> cart;
    var rawCart = session.getAttribute("CART");
    if (rawCart instanceof HashMap) {
      cart = (HashMap<Long, OrderLine>) rawCart;      
    } else {
      cart = new HashMap<>(); 
    }
    Optional<Product> product = productRepo.findById(id);
    if (product.isPresent()) {
      OrderLine orderLine = cart.get(id);
      if (orderLine == null) {
        cart.put(id, new OrderLine(product.get(), 1));
      } else{
        orderLine.decrease();
        System.out.println(orderLine);
        cart.put(id, orderLine);
        session.setAttribute("CART", session.getAttribute("CART"));
      }
      if(orderLine.getCount() <= 0){
        cart.remove(id, orderLine);
      }
    }
  }

  public int countItemInCart(HttpSession session) {
    HashMap<Long, OrderLine> cart;

    var rawCart = session.getAttribute("CART");

    if (rawCart instanceof HashMap) {
      cart = (HashMap<Long, OrderLine>) rawCart;
      return cart.values().stream().mapToInt(OrderLine::getCount).sum();
    } else {
      return 0;
    }
  }

  public Cart getCart(HttpSession session) {
    HashMap<Long, OrderLine> cart;

    var rawCart = session.getAttribute("CART");

    if (rawCart instanceof HashMap) {
      cart = (HashMap<Long, OrderLine>) rawCart;
      return new Cart(
          (cart.values().stream()).collect(Collectors.toList()), // danh sách các mặt hàng mua
        0.01f, //%Giảm giá
        true   //Có tính thuế VAT không?
      );
    } else {
      return new Cart();
    }
  }
}