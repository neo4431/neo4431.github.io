package com.homework.shopingcart.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id = 1L;

    @NotBlank(message = "Không được để trống trường này")
    private String name;

    @NotBlank(message = "Không được để trống trường này")
    private String phoneNumber;

    @NotBlank(message = "Không được để trống trường này")
    @Email(message = "Mail không đúng định dạng")
    private String email;
    
    public User(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.id++;
    }
}