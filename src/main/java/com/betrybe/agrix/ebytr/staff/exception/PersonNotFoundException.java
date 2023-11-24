package com.betrybe.agrix.ebytr.staff.exception;

public class PersonNotFoundException extends RuntimeException {

  public PersonNotFoundException() {
    super("Pessoa não encontrada!");
  }

}
