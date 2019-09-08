package com.rahmitufanoglu.citizenlab.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.rahmitufanoglu.citizenlab.Authority;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_id", updatable = false, nullable = false)
  @JsonProperty("user_id")
  private Long userId;

  @Column(name = "first_name", length = 150, nullable = false)
  @Size(min = 1, max = 150)
  @JsonProperty("first_name")
  private String firstName;

  @Column(name = "last_name", length = 150, nullable = false)
  @Size(min = 1, max = 150)
  @JsonProperty("last_name")
  private String lastName;

  @Column(name = "email", length = 150, nullable = false)
  @Size(min = 5, max = 150)
  @JsonProperty("email")
  private String email;

  @Column(name = "password", length = 256, nullable = false)
  @Size(min = 8, max = 256, message = "The password must be at least 8 characters long")
  @JsonProperty("password")
  private String password;

  @Column(name = "confirm_password", length = 256, nullable = false)
  @Size(min = 8, max = 256)
  @JsonProperty("confirm_password")
  private String confirmPassword;

  /*@Column(name = "role", length = 5, nullable = false)
  @Size(min = 4, max = 5)
  @JsonProperty("role")
  private String role;*/

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

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  @JsonProperty("projects")
  @JsonManagedReference
  private List<Project> projects;

  // constructor without user_id
  public User(@Size(min = 1, max = 150) String firstName, @Size(min = 1, max = 150) String lastName,
      @Size(min = 5, max = 150) String email,
      @Size(min = 8, max = 256, message = "The password must be at least 8 characters long") String password,
      @Size(min = 8, max = 256) String confirmPassword, LocalDateTime createdAt, LocalDateTime updatedAt,
      List<Project> projects) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
    this.confirmPassword = confirmPassword;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.projects = projects;
  }


  /*@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinColumn(name = "authority_id", nullable = false)
  @JsonBackReference
  private Set<Authority> authorities = new HashSet<>();*/

  /*@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  @JsonProperty("authorities")
  @JsonManagedReference
  List<Authority> authorities;*/

    /*List<String> getRoles() {
        if (role.length() > 0) {
            return Arrays.asList(role.split(","));
        }
        return new ArrayList<>();
    }

    List<String> getPermissions() {
        if (permission.length() > 0) {
            return Arrays.asList(permission.split(","));
        }
        return new ArrayList<>();
    }*/
}
