package com.example.javastoreapi.repositories;

import com.example.javastoreapi.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
