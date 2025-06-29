package com.example.javastoreapi.repositories;

import com.example.javastoreapi.entities.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
