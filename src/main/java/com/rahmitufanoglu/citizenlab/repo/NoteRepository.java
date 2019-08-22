package com.rahmitufanoglu.citizenlab.repo;

import com.rahmitufanoglu.citizenlab.model.Note;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface NoteRepository extends CrudRepository<Note, Long> {

  List<Note> findAll();

  Optional<Note> findById(Long noteId);
}
