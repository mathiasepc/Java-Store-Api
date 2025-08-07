package com.example.javastoreapi.dtos;

import com.example.javastoreapi.validation.Lowercase;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

// implies Getter, Setter, ToString and ToHash
@Data
public class RegisterUserRequest {
    // not "" or " "
    @NotBlank(message = "Name cannot be empty")
    @Size(max= 255, message = "Name must be less than 255 characters")
    private String name;

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Email must be valid")
    @Lowercase(message = "Email must be in lowercase")
    private String email;

    @NotBlank(message = "Password cannot be empty")
    @Size(min= 6, max = 25, message = "Must be between 6 to 25 characters long")
    private String password;
}
