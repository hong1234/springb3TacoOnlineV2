package com.hong.flyway.domain;

import java.util.List;
// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
// import jakarta.persistence.ElementCollection;
// import jakarta.persistence.FetchType;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.GrantedAuthority;

import jakarta.validation.constraints.NotBlank;
// import jakarta.validation.constraints.NotNull;
// import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
public class UserAccount { 

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @NotBlank(message = "Username is required")
  @Size(min = 4, max = 10, message = "Username must be between 4 and 10 characters")
  private String username;

  @NotBlank(message = "Password is required")
  @Size(min = 4, max = 10, message = "Password must be between 4 and 10 characters")
  private String password;

  private String authority;

  // @ElementCollection(fetch = FetchType.EAGER)
  // private List<GrantedAuthority> authorities = new ArrayList<>();

  // protected UserAccount() {}

  // public UserAccount(String username, String password, String... authorities) {
  //   this.username = username;
  //   this.password = password;
  //   this.authorities = Arrays.stream(authorities)
  //     .map(SimpleGrantedAuthority::new)
  //     .map(GrantedAuthority.class::cast)
  //     .toList();
  // }

  // public UserDetails asUser() {
  //   return User.builder()
  //     .username(getUsername())
  //     .password(getPassword())
  //     .authorities(getAuthorities())
  //     .build();
  // }

  // public UserAccount(String username, String password, String authority) {
  //   this.username = username;
  //   this.password = password;
  //   this.authority = authority;
  // }

  public UserDetails asUser() {
    return User.builder()
      .username(getUsername())
      .password(getPassword())
      .authorities(List.of(new SimpleGrantedAuthority(getAuthority())))
      .build();
  }

}

