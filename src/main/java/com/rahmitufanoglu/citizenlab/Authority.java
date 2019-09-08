package com.rahmitufanoglu.citizenlab;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.rahmitufanoglu.citizenlab.model.User;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "authority")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Authority implements GrantedAuthority {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "authority_id", updatable = false)
  @JsonProperty("authority_id")
  private Long id;

  @Column(name = "authority", nullable = false)
  @JsonProperty("authority")
  private String authority;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  @JsonBackReference
  private User user;

  public Authority(String authority, User user) {
    this.authority = authority;
    this.user = user;
  }
}
