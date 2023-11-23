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

/**
 * The type Crop service.
 */
@Service
public class CropService {

  private final CropRepository cropRepository;
  private final FertilizerRepository fertilizerRepository;

  /**
   * Instantiates a new Crop service.
   *
   * @param cropRepository       the crop repository
   * @param fertilizerRepository the fertilizer repository
   */
  @Autowired
  public CropService(CropRepository cropRepository, FertilizerRepository fertilizerRepository) {
    this.cropRepository = cropRepository;
    this.fertilizerRepository = fertilizerRepository;
  }

  /**
   * Create crop.
   *
   * @param crop the crop
   * @return the crop
   */
  public Crop create(Crop crop) {
    return cropRepository.save(crop);
  }

  /**
   * Gets all.
   *
   * @return the all
   */
  public List<Crop> getAll() {
    return cropRepository.findAll();
  }

  /**
   * Gets by id.
   *
   * @param id the id
   * @return the by id
   */
  public Crop getById(Long id) {
    return cropRepository.findById(id).orElseThrow(() -> new CropNotFoundException());
  }

  /**
   * Gets crop by date.
   *
   * @param crops     the crops
   * @param startDate the start date
   * @param endDate   the end date
   * @return the crop by date
   */
  public List<Crop> getCropByDate(List<Crop> crops, LocalDate startDate, LocalDate endDate) {
    return crops.stream()
        .filter(crop -> startDate.isBefore(crop.getHarvestDate()) && endDate.isAfter(
            crop.getHarvestDate()))
        .toList();
  }

  /**
   * Associate fertilizer to crop.
   *
   * @param crop       the crop
   * @param fertilizer the fertilizer
   */
  public void associateFertilizerToCrop(Crop crop, Fertilizer fertilizer) {
    crop.addFertilizer(fertilizer);
    fertilizer.getCrops().add(crop);
    cropRepository.save(crop);
    fertilizerRepository.save(fertilizer);
  }

}
