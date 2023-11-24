package com.betrybe.agrix.ebytr.staff.controller.dto;


import com.betrybe.agrix.ebytr.staff.entity.Farm;

public record FarmCreationDto(Long id, String name, Double size) {

  public Farm toEntity() {
    return new Farm(name, size);
  }
}
