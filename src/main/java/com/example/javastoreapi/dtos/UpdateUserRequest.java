package com.example.javastoreapi.dtos;

import lombok.Data;

// implies Getter, Setter, ToString and ToHash
@Data
public class UpdateUserRequest {
    private String name;
    private String email;
}
