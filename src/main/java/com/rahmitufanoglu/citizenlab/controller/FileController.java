package com.rahmitufanoglu.citizenlab.controller;

import com.rahmitufanoglu.citizenlab.model.FileModel;
import com.rahmitufanoglu.citizenlab.service.FileService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/user/{userId}/project/{projectId}/note/{noteId}/file")
public class FileController {

  @Autowired
  private FileService fileService;

  @GetMapping("/{fileName}")
  public FileModel getByName(@PathVariable String fileName) {
    return fileService.get(fileName);
  }

  @PostMapping
  public void create(@PathVariable Long noteId, @Valid @RequestBody FileModel file, @RequestParam MultipartFile multipartFile) {
    fileService.create(noteId, file, multipartFile);
  }

  @PutMapping
  public void update(@PathVariable Long fileId, @Valid @RequestBody FileModel updatedFile) {
    fileService.update(fileId, updatedFile);
  }

  @DeleteMapping
  public void delete(@PathVariable Long fileId) {
    fileService.delete(fileId);
  }
}
