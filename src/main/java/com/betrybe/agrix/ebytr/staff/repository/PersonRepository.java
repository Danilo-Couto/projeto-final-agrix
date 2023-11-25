package com.betrybe.agrix.ebytr.staff.repository;

import com.betrybe.agrix.ebytr.staff.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * The interface Person repository.
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

  /**
   * Find by username person.
   *
   * @param username the username
   * @return the person
   */
  Person findByUsername(String username);

}
