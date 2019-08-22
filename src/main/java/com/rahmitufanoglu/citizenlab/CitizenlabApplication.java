package com.rahmitufanoglu.citizenlab;

import com.rahmitufanoglu.citizenlab.model.Project;
import com.rahmitufanoglu.citizenlab.model.User;
import com.rahmitufanoglu.citizenlab.repo.UserRepository;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CitizenlabApplication implements CommandLineRunner {

  private static final Logger logger = LoggerFactory.getLogger(CitizenlabApplication.class);

  @Autowired
  private UserRepository userRepository;

  public static void main(String[] args) {
    SpringApplication.run(CitizenlabApplication.class, args);
  }

  @Override
  @Transactional
  public void run(String... args) throws Exception {
    /*final List projectList1 = new ArrayList<Project>() {{
      add(new Project("Title 1a", "Desc 1a"));
      add(new Project("Title 1b", "Desc 1b"));
      add(new Project("Title 1c", "Desc 1c"));
    }};

    final User user1 = new User();
    user1.setFirstName("Rahmi");
    user1.setLastName("Tufanoglu");
    user1.setEmail("rahmi@gmail.com");
    user1.setProjectList(projectList1);

    final List projectList2 = new ArrayList<Project>() {{
      add(new Project("Title 2a", "Desc 2a"));
      add(new Project("Title 2b", "Desc 2b"));
      add(new Project("Title 2c", "Desc 2c"));
    }};

    final User user2 = new User();
    user2.setFirstName("Umut");
    user2.setLastName("Tufanoglu");
    user2.setEmail("umut@gmail.com");
    user2.setProjectList(projectList2);

    final List projectList3 = new ArrayList<Project>() {{
      add(new Project("Title 3a", "Desc 3a"));
      add(new Project("Title 3b", "Desc 3b"));
      add(new Project("Title 3c", "Desc 3c"));
    }};

    final User user3 = new User();
    user3.setFirstName("Dilan");
    user3.setLastName("Tufanoglu");
    user3.setEmail("dilan@gmail.com");
    user3.setProjectList(projectList3);

    for (User user : userRepository.findAll()) {
      logger.info(user.toString());
    }*/
  }
}
