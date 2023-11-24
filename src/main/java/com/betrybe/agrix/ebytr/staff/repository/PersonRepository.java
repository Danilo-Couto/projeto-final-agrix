package com.betrybe.agrix.ebytr.staff.repository;

import com.betrybe.agrix.ebytr.staff.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;


public interface PersonRepository extends JpaRepository<Person, Long> {

//  UserDetails findByUsername(String username);
  Person findByUsername(String username);

}
