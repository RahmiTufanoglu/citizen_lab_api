package com.rahmitufanoglu.citizenlab.service;

import com.rahmitufanoglu.citizenlab.exception.ResourceNotFoundException;
import com.rahmitufanoglu.citizenlab.model.Note;
import com.rahmitufanoglu.citizenlab.model.Project;
import com.rahmitufanoglu.citizenlab.repo.NoteRepository;
import com.rahmitufanoglu.citizenlab.repo.ProjectRepository;
import com.rahmitufanoglu.citizenlab.repo.UserRepository;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class NoteService {

  @Autowired
  private NoteRepository noteRepository;

  @Autowired
  private ProjectRepository projectRepository;

  @Autowired
  private UserRepository userRepository;

  public List<Note> findAllNotes(Long projectId) {
    Optional<Project> optionalProject = projectRepository.findById(projectId);
    if (optionalProject.isPresent()) {
      return optionalProject.get().getNoteList();
    } else {
      throw new ResourceNotFoundException();
    }
  }

  public Note findProjectById(Long noteId) {
    Optional<Note> optionalNote = noteRepository.findById(noteId);
    if (optionalNote.isPresent()) {
      return optionalNote.get();
    } else {
      throw new ResourceNotFoundException();
    }
  }

  public void createNote(Long projectId, Note note) {
    Optional<Project> optionalProject = projectRepository.findById(projectId);
    if (optionalProject.isPresent()) {
      note.setProject(optionalProject.get());
      noteRepository.save(note);
    } else {
      throw new ResourceNotFoundException();
    }
  }

  public void updateNote(Long noteId, Note updatedNote) {
    Optional<Note> optionalNote = noteRepository.findById(noteId);
    if (optionalNote.isPresent()) {
      optionalNote.get().setTitle(updatedNote.getTitle());
      optionalNote.get().setDescription(updatedNote.getDescription());
      noteRepository.save(optionalNote.get());
    } else {
      throw new ResourceNotFoundException();
    }
  }

  public void deleteNote(Long noteId) {
    Optional<Note> optionalNote = noteRepository.findById(noteId);
    if (optionalNote.isPresent()) {
      projectRepository.deleteById(noteId);
    } else {
      throw new ResourceNotFoundException();
    }
  }

  /*public void saveImage(MultipartFile imageFile, String folder) throws IOException {
    byte[] bytes = imageFile.getBytes();
    Path path = Paths.get(folder + imageFile.getOriginalFilename());
    Files.write(path, bytes);
  }*/
}
