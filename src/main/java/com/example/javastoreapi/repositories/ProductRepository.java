package com.example.javastoreapi.repositories;

import com.example.javastoreapi.entities.Product;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // We had unnecessary queries. EntityGraph removed that
    @EntityGraph(attributePaths = "category")
    List<Product> findByCategoryId(Byte categoryId);

    // We skip a lot of unnecessary queries
    @Query("SELECT p FROM Product p JOIN FETCH p.category")
    List<Product> findAllWithCategory();
}
