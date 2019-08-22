package com.rahmitufanoglu.citizenlab.controller;

import com.rahmitufanoglu.citizenlab.model.Project;
import com.rahmitufanoglu.citizenlab.service.ProjectService;
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
@RequestMapping("/user/{userId}")
public class ProjectController {

  @Autowired
  private ProjectService projectService;

  @GetMapping("/project/all")
  public List<Project> getAll(@PathVariable Long userId) {
    return projectService.getAllProjects(userId);
  }

  @GetMapping("/project/{projectId}")
  public Project getById(@PathVariable Long projectId) {
    return projectService.getProject(projectId);
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping("/project")
  public void create(@PathVariable Long userId, @Valid @RequestBody Project project) {
    projectService.createProject(userId, project);
  }

  @PutMapping("/project/{projectId}")
  public void update(@PathVariable Long projectId, @Valid @RequestBody Project updatedProject) {
    projectService.updateProject(projectId, updatedProject);
  }

  @DeleteMapping("/project/{projectId}")
  public void delete(@PathVariable Long projectId) {
    projectService.deleteProject(projectId);
  }
}
