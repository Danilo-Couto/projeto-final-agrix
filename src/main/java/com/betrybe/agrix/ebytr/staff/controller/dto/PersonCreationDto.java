package com.betrybe.agrix.ebytr.staff.controller.dto;

import com.betrybe.agrix.ebytr.staff.entity.Person;
import com.betrybe.agrix.ebytr.staff.security.Role;

public record PersonCreationDto(Long id, String username, String password, Role role) {

  public Person toEntity() {
    return new Person(id, username, password, role);
  }
}
