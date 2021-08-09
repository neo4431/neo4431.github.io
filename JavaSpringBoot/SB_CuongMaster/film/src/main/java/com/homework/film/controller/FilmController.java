package com.homework.film.controller;

import java.util.Arrays;
import java.util.List;

import com.homework.film.model.Film;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FilmController {
    
    @GetMapping("/film")
    public String getFilms(Model model){
        List<Film> films = Arrays.asList(
            new Film("Doctor Sleep: Ký Ức Kinh Hoàng", "Phim kinh dị","Mike Flanagan",2019),
            new Film("Us: Chúng ta", "Phim kinh dị","Andy Muschietti",2019),
            new Film("Inception", "Phim hành động","Christopher Nolan",2010),
            new Film("The Raid: Redemption", "Phim hình sự","Mike Flanagan",2011),
            new Film("Edge of Tomorrow", "Phim hành động","Doug Liman",2014));
        model.addAttribute("films", films);
        return "index";
    }
}