package com.rahmitufanoglu.citizenlab.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LoginController {

  @GetMapping("/login")
  public String login() {
    return "Login";
  }
}
