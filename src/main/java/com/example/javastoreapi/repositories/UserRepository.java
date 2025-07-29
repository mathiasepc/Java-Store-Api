package com.example.javastoreapi.repositories;

import com.example.javastoreapi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
