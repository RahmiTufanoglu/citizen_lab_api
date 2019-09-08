package com.rahmitufanoglu.citizenlab.model;

import com.rahmitufanoglu.citizenlab.Authority;
import java.util.Set;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.List;

public class CustomUserDetails extends User implements UserDetails {

  private User user;

  public CustomUserDetails(User user) {
    this.user = user;
  }

  //List<Authority> authorities = new ArrayList<>();

  @Override
  public Set<Authority> getAuthorities() {
    //List<GrantedAuthority> authorities = new ArrayList<>();

        /*user.getPermissions().forEach(p -> {
            GrantedAuthority authority = new SimpleGrantedAuthority(p);
            authorities.add(authority);
        });

        user.getRoles().forEach(r -> {
            GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + r);
            authorities.add(authority);
        });*/

    return null;
  }

  @Override
  public String getPassword() {
    return user.getPassword();
  }

  @Override
  public String getUsername() {
    return user.getFirstName();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
