package com.rahmitufanoglu.citizenlab.controller;

import com.rahmitufanoglu.citizenlab.model.User;
import com.rahmitufanoglu.citizenlab.service.UserService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("/all")
  public List<User> getAll() {
    return userService.getAll();
  }

  @GetMapping("/{userId}")
  public User getById(@PathVariable Long userId) {
    return userService.get(userId);
  }

  @PostMapping
  public void create(@Valid @RequestBody User user) {
    userService.create(user);
  }

  @PutMapping("/{userId}")
  public void update(@PathVariable Long userId, @Valid @RequestBody User updatedUser) {
    userService.update(userId, updatedUser);
  }

  @DeleteMapping("/{userId}")
  public void delete(@PathVariable Long userId) {
    userService.delete(userId);
  }
}
