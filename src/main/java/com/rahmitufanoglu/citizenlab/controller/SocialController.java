package com.rahmitufanoglu.citizenlab.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class SocialController {

  @GetMapping("/")
  public String home() {
    return "home";
  }

  @GetMapping("/user")
  public String user() {
    return "user";
  }

  @GetMapping("/admin")
  public String admin() {
    return "admin";
  }
}
