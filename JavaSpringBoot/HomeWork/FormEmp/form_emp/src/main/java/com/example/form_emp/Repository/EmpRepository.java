package com.example.form_emp.Repository;

import com.example.form_emp.Model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepository extends JpaRepository<Employee, Long>{
}
