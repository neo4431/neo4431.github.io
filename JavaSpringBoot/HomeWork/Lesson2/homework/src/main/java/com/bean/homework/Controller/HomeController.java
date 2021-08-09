package com.bean.homework.Controller;

import com.bean.homework.bean.Tivi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    @Autowired
    Tivi tivi;

    @ResponseBody
    @GetMapping(value="/", produces = MediaType.TEXT_HTML_VALUE)
    public String getHome(){
        return tivi.toString();
    }
}
