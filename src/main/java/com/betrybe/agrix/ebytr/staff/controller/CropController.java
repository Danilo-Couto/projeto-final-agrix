package com.betrybe.agrix.ebytr.staff.controller;

import com.betrybe.agrix.ebytr.staff.controller.dto.ResponseDto;
import com.betrybe.agrix.ebytr.staff.entity.Crop;
import com.betrybe.agrix.ebytr.staff.entity.Fertilizer;
import com.betrybe.agrix.ebytr.staff.service.CropService;
import com.betrybe.agrix.ebytr.staff.service.FertilizerService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * The type Crop controller.
 */
@RestController
@RequestMapping("/crops")
public class CropController {

  @Autowired
  private final CropService cropService;

  @Autowired
  private final FertilizerService fertilizerService;

  /**
   * Instantiates a new Crop controller.
   *
   * @param cropService       the crop service
   * @param fertilizerService the fertilizer service
   */
  public CropController(CropService cropService, FertilizerService fertilizerService) {
    this.cropService = cropService;
    this.fertilizerService = fertilizerService;
  }

  /**
   * Gets all crops.
   *
   * @return the all crops
   */
  @GetMapping
  public ResponseEntity<List<Crop>> getAllCrops() {
    List<Crop> crops = cropService.getAll();
    ResponseDto<List<Crop>> responseDto = new ResponseDto<>("Todas as plantações listadas", crops);
    return ResponseEntity.status(HttpStatus.OK).body(responseDto.data());
  }

  /**
   * Gets crop by id.
   *
   * @param cropId the crop id
   * @return the crop by id
   */
  @GetMapping("/{cropId}")
  public ResponseEntity<Crop> getCropById(@PathVariable Long cropId) {
    Crop crop = cropService.getById(cropId);
    ResponseDto<Crop> responseDto = new ResponseDto<>("Plantação encontrada com sucesso!", crop);
    return ResponseEntity.status(HttpStatus.OK).body(responseDto.data());
  }

  /**
   * Gets crops by date.
   *
   * @param starDate the star date
   * @param endDate  the end date
   * @return the crops by date
   */
  @GetMapping("/search")
  public ResponseEntity<List<Crop>> getCropsByDate(
      @RequestParam(name = "start") LocalDate starDate,
      @RequestParam(name = "end") LocalDate endDate
  ) {
    List<Crop> crops = cropService.getAll();
    List<Crop> cropsByDate = cropService.getCropByDate(crops, starDate, endDate);
    ResponseDto<List<Crop>> responseDto = new ResponseDto<>("Plantaçoes por data",
        cropsByDate);
    return ResponseEntity.status(HttpStatus.OK).body(responseDto.data());
  }

  /**
   * Associate fertilizer to crop response entity.
   *
   * @param cropId       the crop id
   * @param fertilizerId the fertilizer id
   * @return the response entity
   */
  @PostMapping("{cropId}/fertilizers/{fertilizerId}")
  public ResponseEntity<String> associateFertilizerToCrop(
      @PathVariable Long cropId,
      @PathVariable Long fertilizerId
  ) {
    Crop crop = cropService.getById(cropId);
    Fertilizer fertilizer = fertilizerService.getById(fertilizerId);

    cropService.associateFertilizerToCrop(crop, fertilizer);

    ResponseDto<Crop> responseDto = new ResponseDto<>(
        "Fertilizante e plantação associados com sucesso!", crop);
    return ResponseEntity.status(HttpStatus.CREATED).body(responseDto.message());
  }

  /**
   * Gets fertilizers by crop.
   *
   * @param cropId the crop id
   * @return the fertilizers by crop
   */
  @GetMapping("/{cropId}/fertilizers")
  public ResponseEntity<List<Fertilizer>> getFertilizersByCrop(@PathVariable Long cropId) {
    cropService.getById(cropId); // tem que achar plantação pelo Id
    List<Fertilizer> fertilizers = fertilizerService.findFertilizersByCrop(cropId);

    ResponseDto<List<Fertilizer>> responseDto = new ResponseDto<>(
        "Fertilizantes por plantação encontrados com sucesso!", fertilizers);

    return ResponseEntity.status(HttpStatus.OK).body(responseDto.data());
  }

}
