package com.rahmitufanoglu.citizenlab;

import com.rahmitufanoglu.citizenlab.model.Note;
import com.rahmitufanoglu.citizenlab.model.Project;
import com.rahmitufanoglu.citizenlab.model.User;
import com.rahmitufanoglu.citizenlab.repo.NoteRepository;
import com.rahmitufanoglu.citizenlab.repo.ProjectRepository;
import com.rahmitufanoglu.citizenlab.repo.UserRepository;
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
  private UserRepository userRepository;

  @Autowired
  private ProjectRepository projectRepository;

  @Autowired
  private NoteRepository noteRepository;

  public void run(ApplicationArguments args) {
    List<Project> projectList = new ArrayList<>();
    List<Note> noteList = new ArrayList<>();

    User user1 = new User(1L, "Rahmi", "Tufanoglu", "rahmi@gmail.com", "abcdefgh", "abcdefgh", LocalDateTime.now(), LocalDateTime.now(), projectList);
    User user2 = new User(2L, "Umut", "Tufanoglu", "umut@gmail.com", "abcdefgh", "abcdefgh", LocalDateTime.now(), LocalDateTime.now(), projectList);
    User user3 = new User(3L, "Dilan", "Tufanoglu", "dilan@gmail.com", "abcdefgh", "abcdefgh", LocalDateTime.now(), LocalDateTime.now(), projectList);

    Project project1 = new Project(1L, "PTitel 1", "PDesc 1", LocalDateTime.now(), LocalDateTime.now(), user1, noteList);
    Project project2 = new Project(2L, "PTitel 2", "PDesc 2", LocalDateTime.now(), LocalDateTime.now(), user2, noteList);
    Project project3 = new Project(3L, "PTitel 3", "PDesc 3", LocalDateTime.now(), LocalDateTime.now(), user3, noteList);

    Note note1 = new Note(1L, "NTitel 1", "NDesc 1", "path 1", LocalDateTime.now(), LocalDateTime.now(), project1);
    Note note2 = new Note(2L, "NTitel 2", "NDesc 2", "path 2", LocalDateTime.now(), LocalDateTime.now(), project2);
    Note note3 = new Note(3L, "NTitel 3", "NDesc 3", "path 3", LocalDateTime.now(), LocalDateTime.now(), project3);

    userRepository.save(user1);
    userRepository.save(user2);
    userRepository.save(user3);

    projectRepository.save(project1);
    projectRepository.save(project2);
    projectRepository.save(project3);

    noteRepository.save(note1);
    noteRepository.save(note2);
    noteRepository.save(note3);
  }
}
