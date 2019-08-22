package com.rahmitufanoglu.citizenlab.controller;

import com.rahmitufanoglu.citizenlab.model.Note;
import com.rahmitufanoglu.citizenlab.service.NoteService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/{userId}/project/{projectId}")
public class NoteController {

  @Autowired
  private NoteService noteService;

  @GetMapping("/note/all")
  public List<Note> getAll(@PathVariable Long projectId) {
    return noteService.getAll(projectId);
  }

  @GetMapping("/note/{noteId}")
  public Note getById(@PathVariable Long noteId) {
    return noteService.get(noteId);
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping("/note")
  public void create(@PathVariable Long projectId, @Valid @RequestBody Note note) {
    noteService.create(projectId, note);
  }

  @PutMapping("/note/{noteId}")
  public void update(@PathVariable Long noteId, @Valid @RequestBody Note updatedNote) {
    noteService.update(noteId, updatedNote);
  }

  @DeleteMapping("/note/{noteId}")
  public void delete(@PathVariable Long noteId) {
    noteService.delete(noteId);
  }
}
