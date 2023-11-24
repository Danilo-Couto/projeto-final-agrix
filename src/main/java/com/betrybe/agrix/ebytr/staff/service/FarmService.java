package com.betrybe.agrix.ebytr.staff.service;

import com.betrybe.agrix.ebytr.staff.entity.Farm;
import com.betrybe.agrix.ebytr.staff.exception.FarmNotFoundException;
import com.betrybe.agrix.ebytr.staff.repository.FarmRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FarmService {

  private final FarmRepository farmRepository;

  @Autowired
  public FarmService(FarmRepository farmRepository) {
    this.farmRepository = farmRepository;
  }

  public Farm create(Farm fazenda) {
    return farmRepository.save(fazenda);
  }

  public List<Farm> getAll() {
    return farmRepository.findAll();
  }

  public Farm getById(Long id) {
    return farmRepository.findById(id).orElseThrow(() -> new FarmNotFoundException());
  }
}
