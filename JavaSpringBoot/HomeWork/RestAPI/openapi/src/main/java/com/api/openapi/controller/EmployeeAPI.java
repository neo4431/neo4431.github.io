package com.api.openapi.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.api.openapi.model.Employee;
import com.api.openapi.model.EmployeePOJO;
import com.api.openapi.repository.ResourceNotFoundException;
import com.api.openapi.service.IEmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@Validated
@RequestMapping(value = "/api/employees")
public class EmployeeAPI {
    @Autowired
    IEmployeeService empService;

    @Operation(summary = "Get all employees")
    @GetMapping(value = "/")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> listEmp = empService.findAll();
        return ResponseEntity.ok(listEmp);
    }

    @Operation(summary = "Get employee by id")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Employee> getEmployeeById(@Parameter(description = "Nhập id cần tìm") @PathVariable Long id) {
        Optional<Employee> optEmp = empService.findByID(id);
        return ResponseEntity.ok(optEmp.get());

    }

    @Operation(summary = "Get employee by emailID")
    @GetMapping(value = "/search")
    public ResponseEntity<List<Employee>> getEmployeeByEmailID(@RequestParam(required = false) String emailID) {
        if (emailID == null) {
            List<Employee> listEmp = empService.findAll();
            return ResponseEntity.ok(listEmp);
        } else {
            List<Employee> listEmp = new ArrayList<>();
            for (Employee e : empService.findAll()) {
                if (e.getEmailID().equals(emailID)) {
                    listEmp.add(e);
                }
            }

            if (!listEmp.isEmpty()) {
                return ResponseEntity.ok(listEmp);
            } else {
                throw new ResourceNotFoundException();
            }
        }
    }

    @Operation(summary = "Create a new employee")
    @PostMapping(value = "/create")
    public ResponseEntity<Employee> createEmp(
            @Parameter(description = "Employee to be created") @Valid @RequestBody EmployeePOJO emp)
            throws URISyntaxException {
        Employee newEmp = empService.save(emp);
        return ResponseEntity.created(new URI("/employees/" + newEmp.getId())).body(newEmp);
    }

    @Operation(summary = "Update emp by id")
    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Void> updateEmp(@Parameter(description = "id của emp cần cập nhật") @PathVariable Long id,
            @Parameter(description = "thông tin cập nhật") @Valid @RequestBody EmployeePOJO emp) {
        empService.update(id, emp);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Delete emp by id")
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> deleteEmp(@Parameter(description = "id cần xóa") @PathVariable Long id) {
        empService.deleteByID(id);
        return ResponseEntity.ok().build();
    }
}
