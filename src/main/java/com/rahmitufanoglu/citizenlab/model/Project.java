package com.rahmitufanoglu.citizenlab.model;

import com.fasterxml.jackson.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "projects")
@Data
@NoArgsConstructor
@AllArgsConstructor
//@JsonIgnoreProperties({"user"})
@ToString
public class Project {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "project_id", updatable = false, nullable = false)
  @JsonProperty("project_id")
  private Long projectId;

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

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  @JsonBackReference
  private User user;

  @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
  @JsonProperty("project")
  @JsonManagedReference
  private List<Note> notes;

  // constructor without project_id
  public Project(
      @Size(min = 1, max = 150) String title,
      @Size(min = 1, max = 1000) String description,
      LocalDateTime createdAt,
      LocalDateTime updatedAt,
      User user,
      List<Note> notes) {
    this.title = title;
    this.description = description;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.user = user;
    this.notes = notes;
  }
}
