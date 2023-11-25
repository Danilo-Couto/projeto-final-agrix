package com.betrybe.agrix.ebytr.staff.exception;

/**
 * The type Farm not found exception.
 */
public class FarmNotFoundException extends RuntimeException {

  /**
   * Instantiates a new Farm not found exception.
   */
  public FarmNotFoundException() {
    super("Fazenda não encontrada!");
  }
}
