package com.example.javastoreapi.entities;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private BigDecimal price;

    // Cascade.Persist if a table with a relation is saved, the related entity
    // will also be saved.
    @ManyToOne(cascade = CascadeType.PERSIST)
    // Product owns the relation.
    // You must have a foreign key if you want to own the relation
    // Sets name from database foreign key
    @JoinColumn(name = "category_id")
    private Category category;
}