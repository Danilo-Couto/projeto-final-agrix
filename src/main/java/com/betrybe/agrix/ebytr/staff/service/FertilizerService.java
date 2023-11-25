package com.betrybe.agrix.ebytr.staff.service;

import com.betrybe.agrix.ebytr.staff.entity.Fertilizer;
import com.betrybe.agrix.ebytr.staff.exception.FertilizerNotFoundException;
import com.betrybe.agrix.ebytr.staff.repository.FertilizerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Fertilizer service.
 */
@Service
public class FertilizerService {

  private final FertilizerRepository fertilizerRepository;

  /**
   * Instantiates a new Fertilizer service.
   *
   * @param fertilizerRepository the fertilizer repository
   */
  @Autowired
  public FertilizerService(FertilizerRepository fertilizerRepository) {
    this.fertilizerRepository = fertilizerRepository;
  }

  /**
   * Create fertilizer.
   *
   * @param fertilizer the fertilizer
   * @return the fertilizer
   */
  public Fertilizer create(Fertilizer fertilizer) {
    return fertilizerRepository.save(fertilizer);
  }

  /**
   * Gets all.
   *
   * @return the all
   */
  public List<Fertilizer> getAll() {
    return fertilizerRepository.findAll();
  }

  /**
   * Gets by id.
   *
   * @param id the id
   * @return the by id
   */
  public Fertilizer getById(Long id) {
    return fertilizerRepository.findById(id).orElseThrow(() -> new FertilizerNotFoundException());
  }

  /**
   * Find fertilizers by crop list.
   *
   * @param id the id
   * @return the list
   */
  public List<Fertilizer> findFertilizersByCrop(Long id) {
    return fertilizerRepository.findFertilizersByCrop(id);
  }

}
