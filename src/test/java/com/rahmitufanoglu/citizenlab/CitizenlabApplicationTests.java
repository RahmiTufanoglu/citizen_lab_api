package com.rahmitufanoglu.citizenlab;

import com.rahmitufanoglu.citizenlab.model.Project;
import com.rahmitufanoglu.citizenlab.model.User;
import com.rahmitufanoglu.citizenlab.repo.UserRepository;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CitizenlabApplicationTests {

  @Autowired
  UserRepository userRepository;

  @Test
  public void createUser() {
    List<Project> projectList = new ArrayList<>();
    userRepository.save(new User(4L, "Rahmi", "Tufanoglu", "rahmi@gmail.com", "", "", LocalDateTime.now(), LocalDateTime.now(), projectList));
    userRepository.save(new User(5L, "Umut", "Tufanoglu", "umut@gmail.com", "", "", LocalDateTime.now(), LocalDateTime.now(), projectList));
    userRepository.save(new User(6L, "Dilan", "Tufanoglu", "dilan@gmail.com", "", "", LocalDateTime.now(), LocalDateTime.now(), projectList));
  }
}
