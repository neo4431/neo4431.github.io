package com.api.openapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="employee")
@Table(name="employee")
@Data
@NoArgsConstructor
@AllArgsConstructor()
public class Employee {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    @Size(min = 2)
    String firstName;

    @Column(nullable = false)
    @Size(min = 2)
    String lastName;

    @Column(nullable = true)
    @NotBlank
    @Email
    String emailID;

    @Column(nullable = false)
    @Size(min = 2)
    String passportNumber;

}
