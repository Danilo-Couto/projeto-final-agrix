package com.betrybe.agrix.ebytr.staff.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.List;
import lombok.Getter;

/**
 * The type Fertilizer.
 */
@Getter
@Entity
public class Fertilizer {

  /**
   * -- GETTER --
   *  Gets id.
   *
   * @return the id
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /**
   * -- GETTER --
   *  Gets name.
   *
   * @return the name
   */
  private String name;
  /**
   * -- GETTER --
   *  Gets brand.
   *
   * @return the brand
   */
  private String brand;
  /**
   * -- GETTER --
   *  Gets composition.
   *
   * @return the composition
   */
  private String composition;

  /**
   * -- GETTER --
   *  Gets crops.
   *
   * @return the crops
   */
  @ManyToMany(mappedBy = "fertilizers")
  @JsonIgnore
  private List<Crop> crops;

  /**
   * Instantiates a new Fertilizer.
   */
  public Fertilizer() {
  }

  /**
   * Instantiates a new Fertilizer.
   *
   * @param name        the name
   * @param brand       the brand
   * @param composition the composition
   */
  public Fertilizer(String name, String brand, String composition) {
    this.name = name;
    this.brand = brand;
    this.composition = composition;
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
   * Sets brand.
   *
   * @param brand the brand
   */
  public void setBrand(String brand) {
    this.brand = brand;
  }

  /**
   * Sets composition.
   *
   * @param composition the composition
   */
  public void setComposition(String composition) {
    this.composition = composition;
  }

  /**
   * Sets crops.
   *
   * @param crops the crops
   */
  public void setCrops(List<Crop> crops) {
    this.crops = crops;
  }
}
