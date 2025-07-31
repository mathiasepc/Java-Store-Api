package com.example.javastoreapi.dtos;

import lombok.Data;

// implies Getter, Setter, ToString and ToHash
@Data
public class RegisterUserRequest {
    private String name;
    private String email;
    private String password;
}
