package com.example.javastoreapi.controllers;

import com.example.javastoreapi.dtos.UserDto;
import com.example.javastoreapi.mappers.UserMapper;
import com.example.javastoreapi.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@AllArgsConstructor

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @GetMapping
    public Iterable<UserDto> getAllUsers(
            // Sets RequestParam defaultValue and name of attribute
            @RequestParam(required = false, defaultValue = "", name = "sort") String sort
    ) {
        if(!Set.of("name","email").contains(sort))
            sort = "name";

        // findAll, can be used for sort
        return userRepository.findAll(Sort.by(sort))
                .stream()
                .map(userMapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        var user = userRepository.findById(id).orElse(null);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(userMapper.toDto(user));
    }
}
