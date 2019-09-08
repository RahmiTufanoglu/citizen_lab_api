package com.rahmitufanoglu.citizenlab.security;

import com.rahmitufanoglu.citizenlab.service.CustomUserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;


@Configuration
@EnableWebSecurity
@EnableOAuth2Client
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  private static final String ROLE_ADMIN = "ADMIN";
  private static final String ROLE_USER = "USER";

  private static final String LOGIN_PROCESSING_URL = "/login";
  private static final String LOGIN_FAILURE_URL = "/login?error"; //
  private static final String LOGIN_URL = "/login";

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .csrf().disable()
        .authorizeRequests()
        //.antMatchers("/home").permitAll()
        //.antMatchers("/profile/**").authenticated()
        //.antMatchers("/admin/**").hasRole(ROLE_ADMIN)
        //.antMatchers("/api/user/**").hasRole(ROLE_ADMIN)
        //.antMatchers("/api/user/**").authenticated()
        .antMatchers("/api/user/**").permitAll()
        /*.and()
        .formLogin()
        .loginPage("/login").failureUrl("/login?error").permitAll()
        .and()
        .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login")*/
        .and()
        .httpBasic();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    UserDetails adminUser = User.builder()
        .username("rahmi")
        .password(encodePassword().encode("rahmi123"))
        .roles(ROLE_ADMIN, ROLE_USER)
        .build();

    UserDetails normalUser = User.builder()
        .username("umut")
        .password(encodePassword().encode("umut123"))
        .roles(ROLE_USER)
        .build();

    auth.inMemoryAuthentication()
        .withUser(adminUser)
        .withUser(normalUser);
  }

  /*@Override
  protected void configure(AuthenticationManagerBuilder auth) {
    auth.authenticationProvider(authenticationProvider());
  }

  @Bean
  public DaoAuthenticationProvider authenticationProvider() {
    DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
    authenticationProvider.setPasswordEncoder(encodePassword());
    authenticationProvider.setUserDetailsService(new CustomUserDetailService());
    return authenticationProvider;
  }*/

  @Bean
  public BCryptPasswordEncoder encodePassword() {
    return new BCryptPasswordEncoder(12);
  }
}
