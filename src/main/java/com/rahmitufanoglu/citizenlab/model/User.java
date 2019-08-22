package com.rahmitufanoglu.citizenlab.model;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_id", updatable = false, nullable = false)
  private Long userId;

  @Column(name = "first_name", length = 150)
  @Size(min = 1, max = 150)
  private String firstName;

  @Column(name = "last_name", length = 150)
  @Size(min = 1, max = 150)
  private String lastName;

  @Column(name = "email", length = 150)
  @Size(min = 5, max = 150)
  private String email;

  @Column(name = "password", length = 256)
  @Size(min = 8, max = 256)
  private String password;

  @Column(name = "confirm_password", length = 256)
  @Size(min = 8, max = 256)
  private String confirmPassword;

  @Column(name = "created_at")
  private LocalDateTime createdAt;

  @Column(name = "updated_at")
  private LocalDateTime updatedAt;

  @PrePersist
  void onCreate() {
    createdAt = LocalDateTime.now();
  }

  @PreUpdate
  void onUpdate() {
    updatedAt = LocalDateTime.now();
  }

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<Project> projectList;
}
