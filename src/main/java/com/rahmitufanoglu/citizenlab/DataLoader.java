package com.rahmitufanoglu.citizenlab;

import com.rahmitufanoglu.citizenlab.model.Note;
import com.rahmitufanoglu.citizenlab.model.Project;
import com.rahmitufanoglu.citizenlab.model.User;
import com.rahmitufanoglu.citizenlab.service.FileService;
import com.rahmitufanoglu.citizenlab.service.NoteService;
import com.rahmitufanoglu.citizenlab.service.ProjectService;
import com.rahmitufanoglu.citizenlab.service.UserService;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

  @Autowired
  private UserService userService;

  @Autowired
  private ProjectService projectService;

  @Autowired
  private NoteService noteService;

  @Autowired
  private FileService fileService;

  public void run(ApplicationArguments args) {
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

    /*FileModel fileModel1 = new FileModel(1L, "File1", "", null, note1);
    FileModel fileModel2 = new FileModel(2L, "File2", "", null, note2);
    FileModel fileModel3 = new FileModel(3L, "File3", "", null, note3);*/

    userService.create(user1);
    userService.create(user2);
    userService.create(user3);

    projectService.create(user1.getUserId(), project1);
    projectService.create(user2.getUserId(), project2);
    projectService.create(user3.getUserId(), project3);

    noteService.create(project1.getProjectId(), note1);
    noteService.create(project2.getProjectId(), note2);
    noteService.create(project3.getProjectId(), note3);

    /*fileService.create(1L, fileModel1, null);
    fileService.create(2L, fileModel2, null);
    fileService.create(3L, fileModel3, null);*/
  }
}
