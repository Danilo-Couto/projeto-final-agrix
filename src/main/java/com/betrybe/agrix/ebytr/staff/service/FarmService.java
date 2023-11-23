package com.betrybe.agrix.ebytr.staff.service;

import com.betrybe.agrix.ebytr.staff.entity.Farm;
import com.betrybe.agrix.ebytr.staff.exception.FarmNotFoundException;
import com.betrybe.agrix.ebytr.staff.repository.FarmRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Fazenda service.
 */
@Service
public class FarmService {

  private final FarmRepository farmRepository;

  /**
   * Instantiates a new Fazenda service.
   *
   * @param farmRepository the fazenda repository
   */
  @Autowired
  public FarmService(FarmRepository farmRepository) {
    this.farmRepository = farmRepository;
  }

  /**
   * Create fazenda.
   *
   * @param fazenda the fazenda
   * @return the fazenda
   */
  public Farm create(Farm fazenda) {
    return farmRepository.save(fazenda);
  }

  /**
   * Gets all.
   *
   * @return the all
   */
  public List<Farm> getAll() {
    return farmRepository.findAll();
  }

  /**
   * Gets by id.
   *
   * @param id the id
   * @return the by id
   */
  public Farm getById(Long id) {
    return farmRepository.findById(id).orElseThrow(() -> new FarmNotFoundException());
  }
}
