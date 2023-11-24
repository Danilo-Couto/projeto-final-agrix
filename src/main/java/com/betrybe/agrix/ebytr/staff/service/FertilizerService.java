package com.betrybe.agrix.ebytr.staff.service;

import com.betrybe.agrix.ebytr.staff.entity.Fertilizer;
import com.betrybe.agrix.ebytr.staff.exception.FertilizerNotFoundException;
import com.betrybe.agrix.ebytr.staff.repository.FertilizerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FertilizerService {

  private final FertilizerRepository fertilizerRepository;

  @Autowired
  public FertilizerService(FertilizerRepository fertilizerRepository) {
    this.fertilizerRepository = fertilizerRepository;
  }

  public Fertilizer create(Fertilizer fertilizer) {
    return fertilizerRepository.save(fertilizer);
  }

  public List<Fertilizer> getAll() {
    return fertilizerRepository.findAll();
  }

  public Fertilizer getById(Long id) {
    return fertilizerRepository.findById(id).orElseThrow(() -> new FertilizerNotFoundException());
  }

  public List<Fertilizer> findFertilizersByCrop(Long id) {
    return fertilizerRepository.findFertilizersByCrop(id);
  }

}
