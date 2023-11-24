package com.betrybe.agrix.ebytr.staff.exception;

public class FarmNotFoundException extends RuntimeException {

  public FarmNotFoundException() {
    super("Fazenda não encontrada!");
  }
}
