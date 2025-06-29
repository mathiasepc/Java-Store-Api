package com.example.javastoreapi.repositories;

import com.example.javastoreapi.entities.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
}
