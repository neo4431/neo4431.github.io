package com.homework.upload.service;

import java.util.List;
import java.util.Optional;

import com.homework.upload.exception.ResourceNotFoundException;
import com.homework.upload.model.Person;
import com.homework.upload.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService implements PersonServiceI {
    @Autowired
    private PersonRepository personRepo;

    @Override
    public List<Person> findAll() {
        return personRepo.findAll();
    }

    @Override
    public Person findById(Long id) {
        return personRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy người dùng!!!"));
    }

    @Override
    public void add(Person person) {
        personRepo.save(person);
    }

    @Override
    public void update(Person person) {
            personRepo.save(person);
    }

    @Override
    public void delete(Long id) {
        Optional<Person> optPerson = personRepo.findById(id);
        if(optPerson.isPresent()){
            personRepo.delete(optPerson.get());
        } else {
            throw new ResourceNotFoundException("Không tìm thấy người dùng!!!");
        }
    }
}