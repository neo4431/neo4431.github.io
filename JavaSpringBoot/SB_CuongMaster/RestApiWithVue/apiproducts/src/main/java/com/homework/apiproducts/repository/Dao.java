package com.homework.apiproducts.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class Dao<T> {
    List<T> collections = new ArrayList<>();

    public abstract List<T> getAll();

    public abstract Optional<T> getById(Long id);

    public abstract void add(T t);

    public abstract void update(T t);

    public abstract void delete(T t);

    public abstract List<T> searchByKeyword(String keyword, String sort);
}