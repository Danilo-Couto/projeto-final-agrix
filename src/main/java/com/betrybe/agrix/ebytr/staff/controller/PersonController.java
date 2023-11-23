package com.betrybe.agrix.ebytr.staff.controller;

import com.betrybe.agrix.ebytr.staff.controller.dto.ResponseDto;
import com.betrybe.agrix.ebytr.staff.entity.Person;
import com.betrybe.agrix.ebytr.staff.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Fazenda controller.
 */
@RestController
@RequestMapping("/person")
public class PersonController {

  @Autowired
  private final PersonService personService;

  /**
   * Instantiates a new Person controller.
   *
   * @param personService the person service
   */
  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  /**
   * Gets person by id.
   *
   * @param personId the person id
   * @return the person by id
   */
  @GetMapping("/{personId}")
  public ResponseEntity<Person> getPersonById(@PathVariable Long personId) {
    Person person = personService.getPersonById(personId);
    ResponseDto<Person> responseDto = new ResponseDto<>("Pessoa encontrada com sucesso!",
        person);
    return ResponseEntity.status(HttpStatus.OK).body(responseDto.data());
  }

}
