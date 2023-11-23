package com.betrybe.agrix.ebytr.staff.controller.dto;


import com.betrybe.agrix.ebytr.staff.entity.Farm;

/**
 * The type Fazenda creation dto.
 */
public record FarmCreationDto(Long id, String name, Double size) {

  /**
   * To entity fazenda.
   *
   * @return the fazenda
   */
  public Farm toEntity() {
    return new Farm(name, size);
  }
}
