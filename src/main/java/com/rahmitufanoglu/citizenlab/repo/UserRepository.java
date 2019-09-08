package com.rahmitufanoglu.citizenlab.repo;

import com.rahmitufanoglu.citizenlab.model.User;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

  List<User> findAll();

  Optional<User> findById(Long userId);

  Optional<User> findByFirstName(String firstName);
}
