package com.betrybe.agrix.ebytr.staff.security;

import lombok.Getter;

/**
 * The enum Role.
 */
@Getter
public enum Role {
  /**
   * Admin role.
   */
  ADMIN("ROLE_ADMIN"),
  /**
   * Manager role.
   */
  MANAGER("ROLE_MANAGER"),
  /**
   * User role.
   */
  USER("ROLE_USER");

  /**
   * -- GETTER --
   *  Gets name.
   *
   * @return the name
   */
  private final String name;

  Role(String name) {
    this.name = name;
  }

}