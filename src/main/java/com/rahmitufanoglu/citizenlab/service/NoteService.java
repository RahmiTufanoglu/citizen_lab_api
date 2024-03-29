package com.rahmitufanoglu.citizenlab.service;

import com.rahmitufanoglu.citizenlab.exception.ResourceNotFoundException;
import com.rahmitufanoglu.citizenlab.model.Note;
import com.rahmitufanoglu.citizenlab.model.Project;
import com.rahmitufanoglu.citizenlab.repo.NoteRepository;
import com.rahmitufanoglu.citizenlab.repo.ProjectRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteService {

  @Autowired
  private NoteRepository noteRepository;

  @Autowired
  private ProjectRepository projectRepository;

  public List<Note> getAll(Long projectId) {
    Optional<Project> optionalProject = projectRepository.findById(projectId);
    if (optionalProject.isPresent()) {
      return optionalProject.get().getNotes();
    } else {
      throw new ResourceNotFoundException();
    }
  }

  public Note get(Long noteId) {
    Optional<Note> optionalNote = noteRepository.findById(noteId);
    if (optionalNote.isPresent()) {
      return optionalNote.get();
    } else {
      throw new ResourceNotFoundException();
    }
  }

  public void create(Long projectId, Note note) {
    Optional<Project> optionalProject = projectRepository.findById(projectId);
    if (optionalProject.isPresent()) {
      note.setProject(optionalProject.get());
      noteRepository.save(note);
    } else {
      throw new ResourceNotFoundException();
    }
  }

  public void update(Long noteId, Note updatedNote) {
    noteRepository.findById(noteId)
        .map(note -> {
          note.setTitle(updatedNote.getTitle());
          note.setDescription(updatedNote.getDescription());
          note.setUpdatedAt(updatedNote.getUpdatedAt());
          return noteRepository.save(note);
        }).orElseThrow(ResourceNotFoundException::new);
  }

  public void delete(Long noteId) {
    Optional<Note> optionalNote = noteRepository.findById(noteId);
    if (optionalNote.isPresent()) {
      projectRepository.deleteById(noteId);
    } else {
      throw new ResourceNotFoundException();
    }
  }

  public void deleteAll() {
    noteRepository.deleteAll();
  }
}
