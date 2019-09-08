package com.rahmitufanoglu.citizenlab.service;

import com.rahmitufanoglu.citizenlab.model.CustomUserDetails;
import com.rahmitufanoglu.citizenlab.model.User;
import com.rahmitufanoglu.citizenlab.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailService implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
    Optional<User> user = userRepository.findByFirstName(s);
    if (user.isPresent()) {
      return new CustomUserDetails(user.get());
    } else {
      throw new UsernameNotFoundException("User not found");
    }
  }
}
