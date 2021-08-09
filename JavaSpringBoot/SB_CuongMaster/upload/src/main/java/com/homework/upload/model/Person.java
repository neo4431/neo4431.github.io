package com.homework.upload.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="people")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "{not.null}")
    @Size(min = 5, max = 50, message = "{name.size}")
    @Column(name="FULL_NAME")
    private String fullName;

    @NotNull(message = "{not.null}")
    @Column(name="JOB")
    private String job;

    @NotNull(message = "{not.null}")
    @Column(name="GENDER")
    private String gender;

    @NotNull(message = "{not.null}")
    @NotBlank(message = "{not.null}")
    @Column(name="DOB")
    private String birthDate;

    @Transient
    private MultipartFile file;
}