package com.rahmitufanoglu.citizenlab.model;

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
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

  @Column(name = "title", length = 150)
  @Size(min = 1, max = 150)
  @JsonProperty("title")
  private String title;

  @Column(name = "description", length = 1000)
  @Size(min = 1, max = 1000)
  @JsonProperty("description")
  private String description;

  @Column(name = "created_at")
  @JsonProperty("created_at")
  private LocalDateTime createdAt;

  @Column(name = "updated_at")
  @JsonProperty("updated_at")
  private LocalDateTime updatedAt;

  @PrePersist
  void onCreate() {
    createdAt = LocalDateTime.now();
  }

  @PreUpdate
  void onUpdate() {
    updatedAt = LocalDateTime.now();
  }

  @ManyToOne(fetch = FetchType.LAZY, targetEntity = Project.class)
  @JoinColumn(name = "project_id", nullable = false)
  @JsonProperty("project")
  private Project project;

  @OneToOne(mappedBy = "note", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JsonProperty("file")
  private FileModel file;
}
