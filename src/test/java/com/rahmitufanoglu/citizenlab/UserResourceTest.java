package com.rahmitufanoglu.citizenlab;

import static org.junit.Assert.assertEquals;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rahmitufanoglu.citizenlab.model.Project;
import com.rahmitufanoglu.citizenlab.model.User;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserResourceTest {

  private MockMvc mockMvc;

  @Autowired
  private WebApplicationContext webApplicationContext;

  @Autowired
  private ObjectMapper objectMapper = new ObjectMapper();

  @Before
  public void setUp() {
    mockMvc = MockMvcBuilders
        .webAppContextSetup(webApplicationContext)
        .apply(springSecurity())
        .build();
  }


  @Test
  @WithMockUser
  public void testAddUser() throws Exception {
    List<Project> projectList = new ArrayList<>();
    User user1 = new User("Eren", "Jaeger", "eren.jaeger@gmail.com", "abcdefgh", "abcdefgh", LocalDateTime.now(), LocalDateTime.now(), projectList);

    String jsonRequest = objectMapper.writeValueAsString(user1);

    MvcResult result = mockMvc.perform(post("/api/user")
        .content(jsonRequest)
        .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andReturn();

    assertEquals(200, result.getResponse().getStatus());
  }

  @Test
  @WithMockUser
  public void getUserTest() throws Exception {
    MvcResult result = mockMvc.perform(get("/api/user/all")
        .content(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(status().isOk())
        .andReturn();

    assertEquals(200, result.getResponse().getStatus());
  }
}
