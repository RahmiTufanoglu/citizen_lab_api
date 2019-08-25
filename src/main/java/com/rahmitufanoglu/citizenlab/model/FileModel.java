package com.rahmitufanoglu.citizenlab.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "files")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"note"})
public class FileModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonProperty("file_id")
  private Long fileId;

  private String name;

  private String type;

  @Lob
  private byte[] data;

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "note_id")
  @JsonProperty("note")
  private Note note;

  public FileModel(String name, String type, byte[] data) {
    this.name = name;
    this.type = type;
    this.data = data;
  }

  // constructor without file_id
  public FileModel(String name, String type, byte[] data, Note note) {
    this.name = name;
    this.type = type;
    this.data = data;
    this.note = note;
  }
}
