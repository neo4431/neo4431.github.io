package com.homework.upload.service;

import java.util.List;
import java.util.Optional;

import com.homework.upload.exception.ResourceNotFoundException;
import com.homework.upload.model.Job;
import com.homework.upload.repository.JobRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService implements JobServiceI {
    @Autowired
    private JobRepository jobRepo;

    @Override
    public List<Job> findAll() {
        return jobRepo.findAll();
    }

    @Override
    public Job findById(Long id) {
        return jobRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy job!!!"));
    }

    @Override
    public void add(Job job) {
        List<Job> jobs = this.findAll();
        Boolean isCheck = true;
        String newJobName = job.getName().toLowerCase().trim();
        for (Job ele : jobs) {
            if (ele.getName().toLowerCase().equals(newJobName)) {
                isCheck = false;
                break;
            }
        }
        if(isCheck){
            jobRepo.save(job);
        }
    }

    @Override
    public void deleteById(Long id) {
        Optional<Job> jobOptional = jobRepo.findById(id);
        if(jobOptional.isPresent()){
            jobRepo.delete(jobOptional.get());
        } else {
            throw new ResourceNotFoundException("Không tìm thấy job!!!");
        }
    }
}