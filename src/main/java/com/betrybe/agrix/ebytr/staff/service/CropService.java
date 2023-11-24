package com.betrybe.agrix.ebytr.staff.service;

import com.betrybe.agrix.ebytr.staff.entity.Crop;
import com.betrybe.agrix.ebytr.staff.entity.Fertilizer;
import com.betrybe.agrix.ebytr.staff.exception.CropNotFoundException;
import com.betrybe.agrix.ebytr.staff.repository.CropRepository;
import com.betrybe.agrix.ebytr.staff.repository.FertilizerRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CropService {

  private final CropRepository cropRepository;
  private final FertilizerRepository fertilizerRepository;

  @Autowired
  public CropService(CropRepository cropRepository, FertilizerRepository fertilizerRepository) {
    this.cropRepository = cropRepository;
    this.fertilizerRepository = fertilizerRepository;
  }

  public Crop create(Crop crop) {
    return cropRepository.save(crop);
  }

  public List<Crop> getAll() {
    return cropRepository.findAll();
  }

  public Crop getById(Long id) {
    return cropRepository.findById(id).orElseThrow(() -> new CropNotFoundException());
  }

  public List<Crop> getCropByDate(List<Crop> crops, LocalDate startDate, LocalDate endDate) {
    return crops.stream()
        .filter(crop -> startDate.isBefore(crop.getHarvestDate()) && endDate.isAfter(
            crop.getHarvestDate()))
        .toList();
  }

  public void associateFertilizerToCrop(Crop crop, Fertilizer fertilizer) {
    crop.addFertilizer(fertilizer);
    fertilizer.getCrops().add(crop);
    cropRepository.save(crop);
    fertilizerRepository.save(fertilizer);
  }

}
