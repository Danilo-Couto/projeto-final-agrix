package com.betrybe.agrix.ebytr.staff.entity;

import com.betrybe.agrix.ebytr.staff.security.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Collection;
import java.util.List;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * The type Person.
 */
@Getter
@Entity
@JsonIgnoreProperties({"password", "accountNonExpired", "accountNonLocked", "credentialsNonExpired",
    "enabled"})
public class Person implements UserDetails, GrantedAuthority {

  /**
   * -- GETTER --
   *  Gets id.
   *
   * @return the id
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true)
  private String username;

  private String password;

  /**
   * -- GETTER --
   *  Gets role.
   *
   * @return the role
   */
  private Role role;

  /**
   * Instantiates a new Person.
   */
  public Person() {
  }

  /**
   * Instantiates a new Person.
   *
   * @param id       the id
   * @param username the username
   * @param password the password
   * @param role     the role
   */
  public Person(Long id, String username, String password, Role role) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.role = role;
  }

  /**
   * Sets id.
   *
   * @param id the id
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Sets username.
   *
   * @param username the username
   */
  public void setUsername(String username) {
    this.username = username;
  }

  /**
   * Sets password.
   *
   * @param password the password
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * Sets role.
   *
   * @param role the role
   */
  public void setRole(Role role) {
    this.role = role;
  }

  @Override
  @JsonIgnore
  public Collection<Person> getAuthorities() {
    return List.of(this);
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

  @JsonIgnore
  @Override
  public String getAuthority() {
    return role.getName();
  }

}

