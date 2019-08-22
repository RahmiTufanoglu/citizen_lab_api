package com.rahmitufanoglu.citizenlab.exception;

import com.rahmitufanoglu.citizenlab.model.EntryErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionController {

  @ExceptionHandler
  public ResponseEntity<EntryErrorResponse> handleException(
      ResourceNotFoundException resourceNotFoundException) {
    EntryErrorResponse entryErrorResponse = new EntryErrorResponse();

    entryErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
    entryErrorResponse.setMessage(resourceNotFoundException.getMessage());
    entryErrorResponse.setTimeStamp(System.currentTimeMillis());

    return new ResponseEntity<>(entryErrorResponse, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler
  public ResponseEntity<EntryErrorResponse> handleException(Exception exception) {
    EntryErrorResponse entryErrorResponse = new EntryErrorResponse();

    entryErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
    entryErrorResponse.setMessage(exception.getMessage());
    entryErrorResponse.setTimeStamp(System.currentTimeMillis());

    return new ResponseEntity<>(entryErrorResponse, HttpStatus.BAD_REQUEST);
  }
}
