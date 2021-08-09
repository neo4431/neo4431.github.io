package com.homework.shopingcart.controller;

import java.util.Locale;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import com.homework.shopingcart.model.User;
import com.homework.shopingcart.repository.ProducRepository;
import com.homework.shopingcart.service.CartService;
import com.homework.shopingcart.util.MailConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    @Autowired
    private ProducRepository productRepo;
    @Autowired
    private CartService cartService;
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private MailConstructor mailConstructor;

    @GetMapping("")
    public String index(HttpSession session, Model model) {
        model.addAttribute("products", productRepo.findAll());
        model.addAttribute("count", cartService.countItemInCart(session));
        return "index";
    }

    @GetMapping("/add-to-cart/{id}")
    public String addToCart(@PathVariable Long id, HttpSession session, Model model) {
        cartService.addToCart(id, session);
        return "redirect:/";
    }

    @GetMapping("/check-out")
    public String checkOut(Model model, HttpSession session) {
        model.addAttribute("count", cartService.countItemInCart(session));
        model.addAttribute("cart", cartService.getCart(session));
        model.addAttribute("user", new User());
        return "checkout";
    }

    @GetMapping("/decrease/{id}")
    public String decreaseCount(@PathVariable Long id, Model model, HttpSession session) {
        cartService.decreaseToCart(id, session);
        model.addAttribute("count", cartService.countItemInCart(session));
        model.addAttribute("cart", cartService.getCart(session));
        return "redirect:/check-out";
    }

    @GetMapping("/increase/{id}")
    public String increaseCount(@PathVariable Long id, Model model, HttpSession session) {
        cartService.addToCart(id, session);
        return "redirect:/check-out";
    }

    @PostMapping("/")
    public String paymentConfirm(@Valid @ModelAttribute User user, BindingResult bindingResult, HttpSession session,
            Model model) {
        if (!bindingResult.hasErrors()) {
            mailSender.send(mailConstructor.constructOrderConfirmationEmail(user, cartService.getCart(session),
                    Locale.ENGLISH));
            model.addAttribute("products", productRepo.findAll());
            model.addAttribute("count", cartService.countItemInCart(session));
            session.invalidate();
            return "success";
        }
        model.addAttribute("count", cartService.countItemInCart(session));
        model.addAttribute("cart", cartService.getCart(session));
        return "checkout";
    }
}