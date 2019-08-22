package com.rahmitufanoglu.citizenlab.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
  private String firstName;
  @Column(name = "last_name", length = 150)
  private String lastName;
  @Column(name = "email", length = 150)
  private String email;
  /*private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  @PrePersist
  void onCreate() {
  }

  @PreUpdate
  void onUpdate() {
  }*/

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<Project> projectList;
}
