package com.api.openapi.service;

import java.util.List;
import java.util.Optional;

import com.api.openapi.model.Employee;
import com.api.openapi.model.EmployeePOJO;

public interface IEmployeeService {
    List<Employee> findAll();

    Optional<Employee> findByID(Long id);

    Employee save(EmployeePOJO employee);

    void update(Long id, EmployeePOJO employee);

    void deleteByID(Long id);
}
