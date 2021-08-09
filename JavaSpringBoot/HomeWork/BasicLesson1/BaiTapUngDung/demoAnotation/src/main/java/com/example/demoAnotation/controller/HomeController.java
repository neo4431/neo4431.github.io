package com.example.demoAnotation.controller;


import java.lang.reflect.Method;

import com.example.demoAnotation.annotation.MyNumberAnnotation;
import com.example.demoAnotation.model.HelloWorld;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HomeController {
    
    @ResponseBody
    @GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    public String getHome() {
        String msg;
    try {
      HelloWorld h = new HelloWorld();
      Method m = h.getClass().getMethod("sayHello");
      msg = "Get value: " + m.getAnnotation(MyNumberAnnotation.class).value(); 
    } catch (Exception e) {
      msg = e.toString();
    }
    return msg; 
    }
}
