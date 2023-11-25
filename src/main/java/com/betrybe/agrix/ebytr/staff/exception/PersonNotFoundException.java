package com.betrybe.agrix.ebytr.staff.exception;

/**
 * The type Person not found exception.
 */
public class PersonNotFoundException extends RuntimeException {

  /**
   * Instantiates a new Person not found exception.
   */
  public PersonNotFoundException() {
    super("Pessoa não encontrada!");
  }

}
