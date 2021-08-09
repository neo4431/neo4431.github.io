package com.homework.cookie.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.homework.cookie.model.Color;
import com.homework.cookie.util.CookieUtil;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    private List<String> colors = Arrays.asList("White", "Pink", "Orange", "Blue", "Black", "Green", "Magento");
    
    @GetMapping()
    public String getHome(Model model) {
        model.addAttribute("bg", "linen");
        model.addAttribute("cl", "maroon");
        model.addAttribute("fs", "0.8em");
        return "home";
    }

    @GetMapping("/blog")
    public String getBlog(Model model) {
        model.addAttribute("bg", "linen");
        model.addAttribute("cl", "maroon");
        model.addAttribute("fs", "0.8em");
        return "blog";
    }

    @GetMapping("/setting")
    public String getSetting(Model model) {
        model.addAttribute("colors", colors);
        model.addAttribute("color", new Color());
        model.addAttribute("bg", "linen");
        model.addAttribute("cl", "maroon");
        model.addAttribute("fs", "0.8em");
        return "setting";
    }

    @PostMapping("/")
    public String changeSetting(@ModelAttribute Color color, HttpServletRequest request, HttpServletResponse response,
            Model model) {
        Cookie bgCookie = CookieUtil.createCookie("bgColor", color.getBackgroundColor(), 10, true, false, "/",
                request.getServerName());
        Cookie fontCookie = CookieUtil.createCookie("fontColor", color.getFontColor(), 10, true, false, "/",
                request.getServerName());
        Cookie fontSizeCookie = CookieUtil.createCookie("fontSize", String.valueOf(color.getFontSize()/10)+"em", 10, true,
                false, "/", request.getServerName());
        response.addCookie(bgCookie);
        response.addCookie(fontCookie);
        response.addCookie(fontSizeCookie);
        model.addAttribute("colors", colors);
        return "setting";
    }

}