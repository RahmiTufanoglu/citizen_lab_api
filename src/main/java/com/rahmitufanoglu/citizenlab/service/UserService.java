package com.rahmitufanoglu.citizenlab.service;

import com.rahmitufanoglu.citizenlab.exception.ResourceNotFoundException;
import com.rahmitufanoglu.citizenlab.model.User;
import com.rahmitufanoglu.citizenlab.repo.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private BCryptPasswordEncoder passwordEncoder;

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
    List<User> users = userRepository.findAll();
    if (!users.isEmpty()) {
      for (User value : users) {
        if (value.getEmail().equals(user.getEmail())) {
          throw new ResourceNotFoundException("The email address is already taken.");
        }
      }
    }
    String password = user.getPassword();
    String encryptedPassword = passwordEncoder.encode(password);
    user.setPassword(encryptedPassword);
    user.setConfirmPassword(encryptedPassword);
    user.setCreatedAt(LocalDateTime.now());
    user.setUpdatedAt(LocalDateTime.now());
    userRepository.save(user);
  }

  public void update(Long userId, User newUser) {
    userRepository.findById(userId)
        .map(user -> {
          user.setFirstName(newUser.getFirstName());
          user.setLastName(newUser.getLastName());
          user.setEmail(newUser.getEmail());
          user.setPassword(newUser.getPassword());
          user.setConfirmPassword(newUser.getConfirmPassword());
          user.setUpdatedAt(newUser.getUpdatedAt());
          return userRepository.save(user);
        }).orElseThrow(ResourceNotFoundException::new);
  }

  public void delete(Long userId) {
    Optional<User> optionalUser = userRepository.findById(userId);
    if (optionalUser.isPresent()) {
      userRepository.delete(optionalUser.get());
    } else {
      throw new ResourceNotFoundException();
    }
  }

  public void deleteAll() {
    userRepository.deleteAll();
  }
}
