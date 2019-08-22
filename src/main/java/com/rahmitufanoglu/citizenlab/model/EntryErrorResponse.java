package com.rahmitufanoglu.citizenlab.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntryErrorResponse {

  private int status;
  private String message;
  private Long timeStamp;
}
