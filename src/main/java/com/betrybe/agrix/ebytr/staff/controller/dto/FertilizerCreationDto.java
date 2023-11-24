package com.betrybe.agrix.ebytr.staff.controller.dto;

import com.betrybe.agrix.ebytr.staff.entity.Fertilizer;

public record FertilizerCreationDto(Long id, String name, String brand, String composition) {

  public Fertilizer toEntity() {
    return new Fertilizer(name, brand, composition);
  }
}
