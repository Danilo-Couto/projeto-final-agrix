package com.betrybe.agrix.ebytr.staff.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

/**
 * The type Farm.
 */
@Getter
@Entity
public class Farm {

  /**
   * -- GETTER --
   *  Gets crops.
   *
   * @return the crops
   */
  @OneToMany(mappedBy = "farm")
  @JsonIgnore
  private final List<Crop> crops = new ArrayList<>();

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
   *  Gets size.
   *
   * @return the size
   */
  private Double size;

  /**
   * Instantiates a new Farm.
   */
  public Farm() {
  }

  /**
   * Instantiates a new Farm.
   *
   * @param name the name
   * @param size the size
   */
  public Farm(String name, Double size) {
    this.name = name;
    this.size = size;
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
   * Sets size.
   *
   * @param size the size
   */
  public void setSize(Double size) {
    this.size = size;
  }

}
