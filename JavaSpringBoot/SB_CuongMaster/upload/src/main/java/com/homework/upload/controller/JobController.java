package com.homework.upload.controller;

import java.util.List;

import javax.validation.Valid;

import com.homework.upload.model.Job;
import com.homework.upload.service.JobServiceI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jobs")
public class JobController {
    @Autowired
    JobServiceI jobService;
    
    @GetMapping("")
    public String getJobs(Model model){
        model.addAttribute("jobs", jobService.findAll());
        model.addAttribute("job", new Job());
        return "jobs";
    }

    @PostMapping("")
    public String addJob(@Valid @ModelAttribute Job job,BindingResult bindingResult, Model model){
        List<Job> jobs = jobService.findAll();
        if(!bindingResult.hasErrors()){
            jobService.add(job);
            if(jobs.size() == jobService.findAll().size()){
                model.addAttribute("msg", "Nghề này đã tồn tại!!!");
            }
        }
        model.addAttribute("jobs", jobService.findAll());
        return "jobs";
    }

    
}