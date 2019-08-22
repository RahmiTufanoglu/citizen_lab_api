package com.rahmitufanoglu.citizenlab;

import com.rahmitufanoglu.citizenlab.model.User;
import com.rahmitufanoglu.citizenlab.repo.UserRepository;
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
		List<User> user = new ArrayList<>() {{
			//add(new User("Rahmi", "Tufanoglu", "rahmi@gmail.com"));
		}};
  }
}
