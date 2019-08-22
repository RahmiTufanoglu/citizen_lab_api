package com.rahmitufanoglu.citizenlab.repo;

import com.rahmitufanoglu.citizenlab.model.Project;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Long> {

  List<Project> findAll();

  Optional<Project> findById(Long projectId);
}
