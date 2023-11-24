package com.betrybe.agrix.ebytr.staff.exception;

public class CropNotFoundException extends RuntimeException {

  public CropNotFoundException() {
    super("Plantação não encontrada!");
  }
}
