package com.betrybe.agrix.ebytr.staff.controller;

import com.betrybe.agrix.ebytr.staff.controller.dto.FarmCreationDto;
import com.betrybe.agrix.ebytr.staff.controller.dto.PersonCreationDto;
import com.betrybe.agrix.ebytr.staff.controller.dto.ResponseDto;
import com.betrybe.agrix.ebytr.staff.entity.Farm;
import com.betrybe.agrix.ebytr.staff.entity.Person;
import com.betrybe.agrix.ebytr.staff.service.PersonService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persons")
public class PersonController {

  @Autowired
  private final PersonService personService;

  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  @GetMapping("/{personId}")
  public ResponseEntity<Person> getPersonById(@PathVariable Long personId) {
    Optional<Person> person = personService.getPersonById(personId);
    ResponseDto<Person> responseDto = new ResponseDto<>("Pessoa encontrada com sucesso!",
        person.get());
    return ResponseEntity.status(HttpStatus.OK).body(responseDto.data());
  }

  @PostMapping
  public ResponseEntity<Person> createPerson(@RequestBody PersonCreationDto personCreationDto) {
    Person newPerson = personService.create(personCreationDto.toEntity());

    ResponseDto<Person> responseDto = new ResponseDto<>("Pessoa criada com sucesso", newPerson);
    return ResponseEntity.status(HttpStatus.CREATED).body(responseDto.data());
  }


}
