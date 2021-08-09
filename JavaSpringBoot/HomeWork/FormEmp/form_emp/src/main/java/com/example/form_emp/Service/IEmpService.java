package com.example.form_emp.Service;

import java.util.List;
import java.util.Optional;

import com.example.form_emp.Model.Employee;


public interface IEmpService {
    List<Employee> findAll();

    Optional<Employee> findById(Long id);

    Employee add(Employee emp);

    Employee update(Long id, Employee emp);

    void deleteById(Long id);
}
