package com.betrybe.agrix.ebytr.staff.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

/**
 * The type Crop.
 */
@Entity
public class Crop {

  @ManyToMany
  @JoinTable(
      name = "crop_fertilizer",
      joinColumns = @JoinColumn(name = "crop_id"),
      inverseJoinColumns = @JoinColumn(name = "fertilizer_id")
  )
  private final List<Fertilizer> fertilizers = new ArrayList<>();
  /**
   * -- GETTER --
   *  Gets id.
   *
   * @return the id
   */
  @Getter
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  /**
   * -- GETTER --
   *  Gets name.
   *
   * @return the name
   */
  @Getter
  private String name;
  /**
   * -- GETTER --
   *  Gets planted area.
   *
   * @return the planted area
   */
  @Getter
  private Double plantedArea;
  /**
   * -- GETTER --
   *  Gets planted date.
   *
   * @return the planted date
   */
  @Getter
  private LocalDate plantedDate;
  /**
   * -- GETTER --
   *  Gets harvest date.
   *
   * @return the harvest date
   */
  @Getter
  private LocalDate harvestDate;
  @ManyToOne
  @JoinColumn(name = "farm_id")
  private Farm farm;

  /**
   * Instantiates a new Crop.
   */
  public Crop() {
  }

  /**
   * Instantiates a new Crop.
   *
   * @param name        the name
   * @param plantedArea the planted area
   * @param farm        the farm
   * @param plantedDate the planted date
   * @param harvestDate the harvest date
   */
  public Crop(String name, Double plantedArea, Farm farm, LocalDate plantedDate,
      LocalDate harvestDate) {
    this.name = name;
    this.plantedArea = plantedArea;
    this.farm = farm;
    this.plantedDate = plantedDate;
    this.harvestDate = harvestDate;
  }

  /**
   * Sets name.
   *
   * @param name the name
   */
  public void setName(String name) {
    this.name = name;
  }


  /**
   * Sets planted area.
   *
   * @param plantedArea the planted area
   */
  public void setPlantedArea(Double plantedArea) {
    this.plantedArea = plantedArea;
  }

  /**
   * Sets size.
   *
   * @param size the size
   */
  public void setSize(Double size) {
    this.plantedArea = size;
  }

  /**
   * Gets farm id.
   *
   * @return the farm id
   */
  public Long getFarmId() {
    return farm.getId();
  }

  /**
   * Sets planted date.
   *
   * @param plantedDate the planted date
   */
  public void setPlantedDate(LocalDate plantedDate) {
    this.plantedDate = plantedDate;
  }

  /**
   * Sets harvest date.
   *
   * @param harvestDate the harvest date
   */
  public void setHarvestDate(LocalDate harvestDate) {
    this.harvestDate = harvestDate;
  }

  /**
   * Add fertilizer.
   *
   * @param fertilizer the fertilizer
   */
  public void addFertilizer(Fertilizer fertilizer) {
    this.fertilizers.add(fertilizer);
  }

}
