package com.betrybe.agrix.ebytr.staff.repository;

import com.betrybe.agrix.ebytr.staff.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;


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
//  UserDetails findByUsername(String username);
  Person findByUsername(String username);

}
