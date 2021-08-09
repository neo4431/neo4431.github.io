package com.homework.upload.controller;

import java.util.Locale;

import javax.validation.Valid;

import com.homework.upload.model.Person;
import com.homework.upload.service.JobServiceI;
import com.homework.upload.service.PersonServiceI;
import com.homework.upload.service.StorageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class PersonController {
    @Autowired
    private PersonServiceI personService;

    @Autowired
    private JobServiceI jobService;

    @Autowired
    private StorageService storageService;

    @Value("${upload.path}")
    private String path;

    @Autowired 
    private MessageSource messageSource;

    @GetMapping("/")
    public String getHome(Model model){
        model.addAttribute("title", "REGISTED");
        model.addAttribute("person", new Person());
        model.addAttribute("jobs", jobService.findAll());
        return "home";
    }

    @GetMapping("/people")
    public String getPeople(Model model){
        model.addAttribute("people", personService.findAll());
        return "people";
    }

    @PostMapping(value="/")
    public String createUser(@Valid @ModelAttribute("person") Person person, BindingResult bindingResult, Model model){
        Locale locale = LocaleContextHolder.getLocale();
        if (person.getFile().getOriginalFilename().isEmpty()) {
            bindingResult.addError(new FieldError("person", "file", messageSource.getMessage("photo.required", null, "Photo required", locale)));
        }
        if(!bindingResult.hasErrors()){
            if(person.getId() == null){
                personService.add(person);
            } else {
                personService.update(person);
            }
            storageService.uploadFile(person.getFile(), person.getId());
            return "success";
        }
        model.addAttribute("jobs", jobService.findAll());
        return "home";
    }

    @GetMapping(value = "/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        Person person = personService.findById(id);
        model.addAttribute("person", person);
        model.addAttribute("jobs", jobService.findAll());
        model.addAttribute("title", "Edit");
        return "home";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable("id") Long id, Model model) {
        personService.delete(id);
        return "redirect:/people";
    }
    
}