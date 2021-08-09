package com.homework.upload.service;

import java.util.List;

import com.homework.upload.model.Job;

public interface JobServiceI {
    public List<Job> findAll();

    public Job findById(Long id);

    public void add(Job job);

    public void deleteById(Long id);
}