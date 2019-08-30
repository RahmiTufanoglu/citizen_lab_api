package com.rahmitufanoglu.citizenlab.security;

import com.rahmitufanoglu.citizenlab.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Autowired
  private UserService userService;

  // Authentication: Who are you? Prove it.
  // HTTP Authentication, Forms Authentication, Certificate, Tokens
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {

    auth.inMemoryAuthentication()
        //.withUser("rahmi").password(encodePassword().encode("rahmi123")).roles("ADMIN").authorities("ACCESS_TEST_1", "ACCESS_TEST_2")
        .withUser("rahmi").password(encodePassword().encode("rahmi123")).roles("ADMIN")
        .and()
        //.withUser("umut").password(encodePassword().encode("umut123")).roles("USER").authorities("ACCESS_TEST_2");
        .withUser("umut").password(encodePassword().encode("umut123")).roles("USER");
  }

  @Bean
  public BCryptPasswordEncoder encodePassword() {
    return new BCryptPasswordEncoder(12);
  }

  // Authorization: What access should I give you?
  // Privileges, Authorities, Roles
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .csrf().disable()
        .authorizeRequests()
        .antMatchers("/home").permitAll()
        .antMatchers("/profile/**").authenticated()
        .antMatchers("/admin/**").hasRole("ADMIN")
        //.antMatchers("/api/user/**").hasAuthority("ACCESS_TEST_2")
        .antMatchers("/api/user/**").authenticated()
        .and()
        .formLogin()
        .loginPage("/login").failureUrl("/login?error").permitAll()
        .and()
        .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login")
        .and()
        .httpBasic();
  }
}
