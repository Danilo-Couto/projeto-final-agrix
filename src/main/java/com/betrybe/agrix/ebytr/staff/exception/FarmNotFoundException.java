package com.betrybe.agrix.ebytr.staff.exception;

/**
 * The type Fazenda not found exception.
 */
public class FarmNotFoundException extends RuntimeException {

  /**
   * Instantiates a new Fazenda not found exception.
   */
  public FarmNotFoundException() {
    super("Fazenda não encontrada!");
  }
}
