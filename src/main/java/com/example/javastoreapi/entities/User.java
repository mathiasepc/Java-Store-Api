package com.example.javastoreapi.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    // Sets who own the relation. We get the value from Address
    // Cascade.Persist if a table with a relation is saved, the related entity
    // will also be saved.
    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
    // instantiate addresses with default values.
    // you will get a NullPointer if Builder.Default is removed.
    @Builder.Default
    private List<Address> addresses = new ArrayList<>();

    public void addAddress(Address address) {
        addresses.add(address);
        address.setUser(this);
    }

    public void removeAddress(Address address) {
        addresses.remove(address);
        address.setUser(null);
    }

    @ManyToMany
    // User owns the relation.
    // You can own a relation if you have a foreign key.
    @JoinTable(
            // Name of the junction table.
            name = "wishlist",
            // id that reference to user tabel.
            joinColumns = @JoinColumn(name = "user_id"),
            // id that reference to product table
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private Set<Product> favoriteProducts = new HashSet<>();

    public void addFavoriteProduct(Product product) {
        favoriteProducts.add(product);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "email = " + email + ")";
    }
}
