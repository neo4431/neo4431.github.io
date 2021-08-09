package com.example.form_emp.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    
    @NotNull(message = "Không được để trống!!!")
	@Size(min = 2, message = "First Name tối thiểu 2 ký tự")
	// @Column(name="FIRST_NAME", nullable = false)
    private String firstName;

    @NotNull(message = "Không được để trống!!!")
	@Size(min = 2, message = "Last Name tối thiểu 2 ký tự")
	// @Column(name="LAST_NAME", nullable = false)
    private String lastName;
    
    @NotBlank(message = "Không được để trống!!!")
    @Email
	// @Column(name="EMAIL_ADDRESS", nullable = false)
    private String emailId;

}
