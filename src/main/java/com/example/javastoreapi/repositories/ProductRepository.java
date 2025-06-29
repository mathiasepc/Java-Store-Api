package com.example.javastoreapi.repositories;

import com.example.javastoreapi.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
