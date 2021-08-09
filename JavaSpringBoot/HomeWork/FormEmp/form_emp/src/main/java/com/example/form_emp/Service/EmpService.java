package com.example.form_emp.Service;

import java.util.List;
import java.util.Optional;

import com.example.form_emp.Exception.ResourceNotFoundException;
import com.example.form_emp.Model.Employee;
import com.example.form_emp.Repository.EmpRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class EmpService implements IEmpService{
    @Autowired
    private EmpRepository empRepository;

    @Override
    public List<Employee> findAll() {
        // TODO Auto-generated method stub
        return empRepository.findAll();
    }

    @Override
    public Optional<Employee> findById(Long id) {
        Optional<Employee> emp = empRepository.findById(id);
        if(emp.isPresent()){
            return emp;
        } else {
            throw new ResourceNotFoundException("Không tìm thấy người dùng có id = " + id);
        }
    }

    @Override
    public Employee add(Employee emp) {
        // TODO Auto-generated method stub
        return empRepository.save(emp);
    }

    @Override
    public Employee update(Long id, Employee emp) {
        // TODO Auto-generated method stub
        Optional<Employee> empOpt = empRepository.findById(id);
        if(empOpt.isPresent()){
            return empRepository.save(emp);
        } else {
            throw new ResourceNotFoundException("Không tìm thấy người dùng có id = " + id);
        }
    }
    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        Optional<Employee> empOpt = empRepository.findById(id);
        if(empOpt.isPresent()){
            empRepository.delete(empOpt.get());
        } else {
            throw new ResourceNotFoundException("Không tìm thấy người dùng có id = " + id);
        }
    }
}
