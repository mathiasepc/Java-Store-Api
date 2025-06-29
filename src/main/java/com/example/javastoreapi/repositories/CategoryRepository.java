package com.example.javastoreapi.repositories;

import com.example.javastoreapi.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
