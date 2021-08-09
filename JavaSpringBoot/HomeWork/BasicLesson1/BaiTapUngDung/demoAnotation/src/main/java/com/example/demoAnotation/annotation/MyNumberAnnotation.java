package com.example.demoAnotation.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MyNumberAnnotation {
    int value();
}
