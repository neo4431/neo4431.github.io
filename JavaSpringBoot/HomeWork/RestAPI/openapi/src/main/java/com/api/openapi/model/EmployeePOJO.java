package com.api.openapi.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class EmployeePOJO {
    @NotNull
    @Schema(description = "Tên", example = "Trung Hiếu", required = true)
    @Size(min = 2, message = "firstName tối thiểu 2 ký tự")
    String firstName;
    
    @NotNull
    @Schema(description = "Họ", example = "Nguyễn", required = true)
    @Size(min = 2, message = "lastName tối thiểu 2 ký tự")
    String lastName;
    
    @NotBlank
    @Email
    @Schema(description = "Email", example = "abc@gmail.com", required = true)
    String emailID;
    
    @NotNull
    @Size(min = 2, message = "Tối thiểu 2 ký tự")
    @Schema(description = "Số hộ chiếu/CCCD/CMT", example = "0123456789", required = true)
    String passportNumber;
}
