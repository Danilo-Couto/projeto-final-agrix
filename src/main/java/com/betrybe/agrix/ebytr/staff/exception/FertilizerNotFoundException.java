package com.betrybe.agrix.ebytr.staff.exception;

/**
 * The type Fertilizer not found exception.
 */
public class FertilizerNotFoundException extends RuntimeException {

  /**
   * Instantiates a new Fertilizer not found exception.
   */
  public FertilizerNotFoundException() {
    super("Fertilizante não encontrado!");
  }
}
