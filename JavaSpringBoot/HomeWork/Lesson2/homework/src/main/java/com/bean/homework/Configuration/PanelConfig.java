package com.bean.homework.Configuration;

import com.bean.homework.bean.Panel;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PanelConfig {
    @Bean(name = "led")
    public Panel ledPanel(){
        return new Panel("LED");
    }
    
    @Bean(name = "oled")
    public Panel oledPanel(){
        return new Panel("OLED");
    }
}
