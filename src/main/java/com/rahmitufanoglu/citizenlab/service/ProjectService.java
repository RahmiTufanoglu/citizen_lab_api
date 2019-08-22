package com.rahmitufanoglu.citizenlab.service;

import com.rahmitufanoglu.citizenlab.exception.ResourceNotFoundException;
import com.rahmitufanoglu.citizenlab.model.Project;
import com.rahmitufanoglu.citizenlab.model.User;
import com.rahmitufanoglu.citizenlab.repo.ProjectRepository;
import com.rahmitufanoglu.citizenlab.repo.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

  @Autowired
  private ProjectRepository projectRepository;

  @Autowired
  private UserRepository userRepository;

  public List<Project> getAllProjects(Long userId) {
    Optional<User> optionalUser = userRepository.findById(userId);
    if (optionalUser.isPresent()) {
      return optionalUser.get().getProjectList();
    } else {
      throw new ResourceNotFoundException();
    }
  }

  public Project getProject(Long projectId) {
    Optional<Project> optionalProject = projectRepository.findById(projectId);
    if (optionalProject.isPresent()) {
      return optionalProject.get();
    } else {
      throw new ResourceNotFoundException();
    }
  }

  public void createProject(Long userId, Project project) {
    Optional<User> optionalUser = userRepository.findById(userId);
    if (optionalUser.isPresent()) {
      project.setUser(optionalUser.get());
      projectRepository.save(project);
    } else {
      throw new ResourceNotFoundException();
    }
  }

  public void updateProject(Long projectId, Project updatedProject) {
    Optional<Project> optionalProject = projectRepository.findById(projectId);
    if (optionalProject.isPresent()) {
      optionalProject.get().setTitle(updatedProject.getTitle());
      optionalProject.get().setDescription(updatedProject.getDescription());
      projectRepository.save(optionalProject.get());
    } else {
      throw new ResourceNotFoundException();
    }
  }

  public void deleteProject(Long projectId) {
    Optional<Project> optionalProject = projectRepository.findById(projectId);
    if (optionalProject.isPresent()) {
      projectRepository.deleteById(projectId);
    } else {
      throw new ResourceNotFoundException();
    }
  }
}
