package com.rahmitufanoglu.citizenlab.repo;

import com.rahmitufanoglu.citizenlab.model.FileModel;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface FileRepository extends CrudRepository<FileModel, Long> {

  Optional<FileModel> findById(Long id);

  Optional<FileModel> findByName(String name);
}
