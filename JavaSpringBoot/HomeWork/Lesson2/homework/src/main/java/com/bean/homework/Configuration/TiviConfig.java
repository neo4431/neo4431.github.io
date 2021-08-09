package com.bean.homework.Configuration;

import com.bean.homework.bean.OS;
import com.bean.homework.bean.Panel;
import com.bean.homework.bean.Tivi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TiviConfig {
    @Autowired
    ApplicationContext context;
    
    @Value("${hdh}")
    private String osType;
    
    @Value("${panel}")
    private String panelType;
    
    

    @Bean
    public Tivi createTivi(){
        Panel panel;
        OS os;
        if(panelType.equals("OLED")){
            panel = (Panel) context.getBean("oled");
        } else {
            panel = (Panel) context.getBean("led");
        }
        if(osType.equals("IOS")){
            os = (OS) context.getBean("ios");
        } else if (osType.equals("Android")){
            os = (OS) context.getBean("android");
        } else if (osType.equals("Flutter")){
            os = (OS) context.getBean("flutter");
        } else {
            os = (OS) context.getBean("normal");
        }
        return new Tivi(panel, os);
    }
}
