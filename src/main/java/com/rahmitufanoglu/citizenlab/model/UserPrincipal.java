package com.rahmitufanoglu.citizenlab.model;

import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserPrincipal implements UserDetails {

  private User user;

  public UserPrincipal(User user) {
    this.user = user;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of(() -> "ADMIN", () -> "USER");

    /*List<GrantedAuthority> authorities = new ArrayList<>();

    user.getPermissionList().forEach(permission -> {
      GrantedAuthority authority = new SimpleGrantedAuthority(permission);
      authorities.add(authority);
    });

    user.getRolesList().forEach(role -> {
      GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + role);
      authorities.add(authority);
    });*/

    //return null;
  }

  @Override
  public String getPassword() {
    return user.getPassword();
  }

  @Override
  public String getUsername() {
    return user.getFirstName() + "_" + user.getLastName();
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
    //return user.getActive() == 1;
    return false;
  }
}
