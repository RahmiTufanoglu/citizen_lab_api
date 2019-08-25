package com.rahmitufanoglu.citizenlab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//@SpringBootApplication
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class CitizenlabApplication {

  //private static final Logger logger = LoggerFactory.getLogger(CitizenlabApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(CitizenlabApplication.class, args);
  }
}
