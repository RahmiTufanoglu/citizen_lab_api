package com.rahmitufanoglu.citizenlab.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "notes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"project"})
public class Note {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "note_id", updatable = false, nullable = false)
  @JsonProperty("note_id")
  private Long noteId;

  @Column(name = "title", length = 150, nullable = false)
  @Size(min = 1, max = 150)
  @JsonProperty("title")
  private String title;

  @Column(name = "description", length = 1000, nullable = false)
  @Size(min = 1, max = 1000)
  @JsonProperty("description")
  private String description;

  @Column(name = "created_at", nullable = false)
  @CreatedDate
  @JsonProperty("created_at")
  @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
  private LocalDateTime createdAt;

  @Column(name = "updated_at", nullable = false)
  @LastModifiedDate
  @JsonProperty("updated_at")
  @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
  private LocalDateTime updatedAt;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "project_id", nullable = false)
  @JsonProperty("project")
  private Project project;

  @OneToOne(mappedBy = "note", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JsonProperty("file")
  private FileModel file;

  // constructor without note_id
  public Note(
      @Size(min = 1, max = 150) String title,
      @Size(min = 1, max = 1000) String description,
      LocalDateTime createdAt,
      LocalDateTime updatedAt,
      Project project,
      FileModel file) {
    this.title = title;
    this.description = description;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.project = project;
    this.file = file;
  }
}
