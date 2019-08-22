package com.rahmitufanoglu.citizenlab.service;

import com.rahmitufanoglu.citizenlab.exception.ResourceNotFoundException;
import com.rahmitufanoglu.citizenlab.model.User;
import com.rahmitufanoglu.citizenlab.repo.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public List<User> getAll() {
    return userRepository.findAll();
  }

  public User get(Long userId) {
    Optional<User> optionalUser = userRepository.findById(userId);
    if (optionalUser.isPresent()) {
      return optionalUser.get();
    } else {
      throw new ResourceNotFoundException();
    }
  }

  public void create(User user) {
    userRepository.save(user);
  }

  public void update(Long userId, User newUser) {
    Optional<User> optionalUser = userRepository.findById(userId);
    if (optionalUser.isPresent()) {
      optionalUser.get().setFirstName(newUser.getFirstName());
      optionalUser.get().setLastName(newUser.getLastName());
    } else {
      throw new ResourceNotFoundException();
    }
  }

  public void delete(Long userId) {
    Optional<User> optionalUser = userRepository.findById(userId);
    if (optionalUser.isPresent()) {
      userRepository.delete(optionalUser.get());
    } else {
      throw new ResourceNotFoundException();
    }
  }
}
