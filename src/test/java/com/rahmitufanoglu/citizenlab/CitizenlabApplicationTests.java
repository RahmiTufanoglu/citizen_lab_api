package com.rahmitufanoglu.citizenlab;

import com.rahmitufanoglu.citizenlab.model.Note;
import com.rahmitufanoglu.citizenlab.model.Project;
import com.rahmitufanoglu.citizenlab.model.User;
import com.rahmitufanoglu.citizenlab.repo.UserRepository;
import com.rahmitufanoglu.citizenlab.service.FileService;
import com.rahmitufanoglu.citizenlab.service.NoteService;
import com.rahmitufanoglu.citizenlab.service.ProjectService;
import com.rahmitufanoglu.citizenlab.service.UserService;
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
  private UserService userService;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private ProjectService projectService;

  @Autowired
  private NoteService noteService;

  @Autowired
  private FileService fileService;

  @Test
  public void createUsersWithProjectsWithNotesWithFile() {
    if (!userService.getAll().isEmpty()) {
      userService.deleteAll();
      projectService.deleteAll();
      noteService.deleteAll();
    } else {
      List<Project> projectList = new ArrayList<>();
      List<Note> noteList = new ArrayList<>();
      //FileModel fileModel = new FileModel();

      User user1 = new User("Rahmi", "Tufanoglu", "rahmi@gmail.com", "abcdefgh", "abcdefgh", LocalDateTime.now(), LocalDateTime.now(), projectList);
      User user2 = new User("Umut", "Tufanoglu", "umut@gmail.com", "abcdefgh", "abcdefgh", LocalDateTime.now(), LocalDateTime.now(), projectList);
      User user3 = new User("Dilan", "Tufanoglu", "dilan@gmail.com", "abcdefgh", "abcdefgh", LocalDateTime.now(), LocalDateTime.now(), projectList);

      Project project1 = new Project(user1.getUserId(), "PTitel 1", "PDesc 1", LocalDateTime.now(), LocalDateTime.now(), user1, noteList);
      Project project2 = new Project(user2.getUserId(), "PTitel 2", "PDesc 2", LocalDateTime.now(), LocalDateTime.now(), user2, noteList);
      Project project3 = new Project(user3.getUserId(), "PTitel 3", "PDesc 3", LocalDateTime.now(), LocalDateTime.now(), user3, noteList);

      Note note1 = new Note(project1.getProjectId(), "NTitel 1", "NDesc 1", LocalDateTime.now(), LocalDateTime.now(), project1, null);
      Note note2 = new Note(project2.getProjectId(), "NTitel 2", "NDesc 2", LocalDateTime.now(), LocalDateTime.now(), project2, null);
      Note note3 = new Note(project3.getProjectId(), "NTitel 3", "NDesc 3", LocalDateTime.now(), LocalDateTime.now(), project3, null);

      /*FileModel fileModel1 = new FileModel(note1.getNoteId(), "File1", "", null, note1);
      FileModel fileModel2 = new FileModel(note2.getNoteId(), "File1", "", null, note2);
      FileModel fileModel3 = new FileModel(note3.getNoteId(), "File1", "", null, note3);*/

      userRepository.save(user1);
      userRepository.save(user2);
      userRepository.save(user3);

      /*fileService.create(note1.getNoteId(), fileModel1, null);
      fileService.create(note2.getNoteId(), fileModel2, null);
      fileService.create(note3.getNoteId(), fileModel3, null);*/
    }
  }

  @Test
  public void createAndDeleteUser() {
    if (!userService.getAll().isEmpty()) {
      userService.deleteAll();
      projectService.deleteAll();
      noteService.deleteAll();
    } else {
      List<Project> projectList = new ArrayList<>();
      List<Note> noteList = new ArrayList<>();
      //FileModel fileModel = new FileModel();

      User user1 = new User("Rahmi", "Tufanoglu", "rahmi@gmail.com", "abcdefgh", "abcdefgh", LocalDateTime.now(), LocalDateTime.now(),
          projectList);
      Project project1 = new Project(user1.getUserId(), "PTitel 1", "PDesc 1", LocalDateTime.now(), LocalDateTime.now(), user1, noteList);
      Note note1 = new Note(project1.getProjectId(), "NTitel 1", "NDesc 1", LocalDateTime.now(), LocalDateTime.now(), project1, null);
      //FileModel fileModel1 = new FileModel(1L, "File1", "", null, note1);

      userService.create(user1);
      projectService.create(user1.getUserId(), project1);
      noteService.create(project1.getProjectId(), note1);
      userService.delete(user1.getUserId());
    }
  }

  @Test
  public void createAndUpdateEmail() {
    if (!userService.getAll().isEmpty()) {
      userService.deleteAll();
      projectService.deleteAll();
      noteService.deleteAll();
    } else {
      List<Project> projectList = new ArrayList<>();
      List<Note> noteList = new ArrayList<>();
      //FileModel fileModel = new FileModel();

      User user1 = new User("Rahmi", "Tufanoglu", "rahmi@gmail.com", "abcdefgh", "abcdefgh", LocalDateTime.now(), LocalDateTime.now(),
          projectList);
      Project project1 = new Project(user1.getUserId(), "PTitel 1", "PDesc 1", LocalDateTime.now(), LocalDateTime.now(), user1, noteList);
      Note note1 = new Note(project1.getProjectId(), "NTitel 1", "NDesc 1", LocalDateTime.now(), LocalDateTime.now(), project1, null);
      //FileModel fileModel1 = new FileModel(1L, "File1", "", null, note1);

      User updatedUser = new User(project1.getProjectId(), "New Rahmi", "New Tufanoglu", "new.rahmi@gmail.com", "newabcdefgh", "newabcdefgh",
          LocalDateTime.now(), LocalDateTime.now(), projectList);

      userService.create(user1);
      projectService.create(user1.getUserId(), project1);
      noteService.create(project1.getProjectId(), note1);
      userService.update(note1.getNoteId(), updatedUser);
    }
  }
}
