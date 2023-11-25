package com.betrybe.agrix.ebytr.staff.controller.dto;

import com.betrybe.agrix.ebytr.staff.entity.Crop;
import com.betrybe.agrix.ebytr.staff.entity.Farm;
import java.time.LocalDate;

/**
 * The type Crop creation dto.
 */
public record CropCreationDto(String name, Double plantedArea, LocalDate plantedDate,
                              LocalDate harvestDate) {

  /**
   * To entity crop.
   *
   * @param farm the farm
   * @return the crop
   */
  public Crop toEntity(Farm farm) {
    return new Crop(name, plantedArea, farm, plantedDate, harvestDate);
  }
}

