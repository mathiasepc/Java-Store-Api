package com.example.javastoreapi.mappers;

import com.example.javastoreapi.dtos.RegisterUserRequest;
import com.example.javastoreapi.dtos.UserDto;
import com.example.javastoreapi.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
   UserDto toDto(User user);
   User toEntity(RegisterUserRequest registerUserRequest);
}
