package com.rahmitufanoglu.citizenlab.service;

import com.rahmitufanoglu.citizenlab.exception.ResourceNotFoundException;
import com.rahmitufanoglu.citizenlab.model.FileModel;
import com.rahmitufanoglu.citizenlab.model.Note;
import com.rahmitufanoglu.citizenlab.repo.FileRepository;
import com.rahmitufanoglu.citizenlab.repo.NoteRepository;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {

  @Autowired
  private NoteRepository noteRepository;

  @Autowired
  private FileRepository fileRepository;

  public FileModel get(String fileName) {
    Optional<FileModel> optionalFile = fileRepository.findByName(fileName);
    if (optionalFile.isPresent()) {
      return optionalFile.get();
    } else {
      throw new ResourceNotFoundException();
    }
  }

  /*public FileModel get(Long noteId) {
    Optional<FileModel> optionalFile = fileRepository.findById(noteId);
    if (optionalFile.isPresent()) {
      return optionalFile.get();
    } else {
      throw new ResourceNotFoundException();
    }
  }*/

  public void create(Long noteId, FileModel file, MultipartFile multipartFile) {
    Optional<Note> optionalNote = noteRepository.findById(noteId);
    if (optionalNote.isPresent()) {
      uploadFile(multipartFile);
      try {
        file.setData(multipartFile.getBytes());
      } catch (IOException e) {
        e.printStackTrace();
      }
      file.setNote(optionalNote.get());
    } else {
      throw new ResourceNotFoundException();
    }
  }

  private void uploadFile(MultipartFile file) {
    try {
      FileModel fileMode = new FileModel(file.getOriginalFilename(), file.getContentType(), file.getBytes());
      fileRepository.save(fileMode);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void update(Long fileId, FileModel updatedFile) {
    Optional<FileModel> optionalFile = fileRepository.findById(fileId);
    if (optionalFile.isPresent()) {
      optionalFile.get().setName(updatedFile.getName());
      optionalFile.get().setData(updatedFile.getData());
    } else {
      throw new ResourceNotFoundException();
    }
  }

  public void delete(Long fileId) {
    Optional<FileModel> optionalFile = fileRepository.findById(fileId);
    if (optionalFile.isPresent()) {
      fileRepository.deleteById(fileId);
    } else {
      throw new ResourceNotFoundException();
    }
  }
}
