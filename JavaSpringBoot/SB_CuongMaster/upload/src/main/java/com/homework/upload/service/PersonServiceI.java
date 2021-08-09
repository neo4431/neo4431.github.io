package com.homework.upload.service;

import java.util.List;

import com.homework.upload.model.Person;

public interface PersonServiceI {
    public List<Person> findAll();

    public Person findById(Long id);

    public void add(Person person);

    public void update(Person person);

    public void delete(Long id);
}