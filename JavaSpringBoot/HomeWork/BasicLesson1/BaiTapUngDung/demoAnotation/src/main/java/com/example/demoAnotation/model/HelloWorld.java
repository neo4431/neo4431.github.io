package com.example.demoAnotation.model;

import com.example.demoAnotation.annotation.MyNumberAnnotation;

public class HelloWorld {
    @MyNumberAnnotation(value = 0)
    public void sayHello(){
        System.out.println("Hello custom annotation");
    }
}
