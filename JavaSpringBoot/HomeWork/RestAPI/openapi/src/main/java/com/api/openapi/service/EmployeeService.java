package com.api.openapi.service;

import java.util.List;
import java.util.Optional;

import com.api.openapi.model.Employee;
import com.api.openapi.model.EmployeePOJO;
import com.api.openapi.repository.EmployeeRepository;
import com.api.openapi.repository.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private EmployeeRepository employeeRepo;

    @Override
    public List<Employee> findAll() {
        return employeeRepo.findAll();
    }

    @Override
    public Optional<Employee> findByID(Long id) {
        Optional<Employee> optEmp = employeeRepo.findById(id);
        if(optEmp.isPresent()){
            return optEmp;
        } else {
            throw new ResourceNotFoundException();
        }
    }

    @Override
    public Employee save(EmployeePOJO employee) {
        Employee newEmp = new Employee(10L, employee.getFirstName(), employee.getLastName(), employee.getEmailID(),
                employee.getPassportNumber());
        return employeeRepo.save(newEmp);
    }

    @Override
    public void update(Long id, EmployeePOJO employee) {
        Employee newEmp = new Employee(id, employee.getFirstName(), employee.getLastName(), employee.getEmailID(),
                employee.getPassportNumber());
        Optional<Employee> optEmp = employeeRepo.findById(id);
        if (optEmp.isPresent()) {
            employeeRepo.save(newEmp);
        } else {
            throw new ResourceNotFoundException();
        }
    }
    
    @Override
    public void deleteByID(Long id) {
        Optional<Employee> deleteEmp = employeeRepo.findById(id);
        if(deleteEmp.isPresent()){
            employeeRepo.delete(deleteEmp.get());
        } else {
            throw new ResourceNotFoundException();
        }
    }
}
