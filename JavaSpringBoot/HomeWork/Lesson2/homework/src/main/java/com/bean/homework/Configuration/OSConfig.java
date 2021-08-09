package com.bean.homework.Configuration;

import com.bean.homework.bean.OS;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OSConfig {
    @Bean(name = "normal")
    public OS normal(){
        return new OS("Normal");
    }
    
    @Bean(name = "ios")
    public OS ios(){
        return new OS("IOS");
    }

    @Bean(name = "android")
    public OS android(){
        return new OS("Android");
    }

    @Bean(name = "flutter")
    public OS flutter(){
        return new OS("Flutter");
    }
}
