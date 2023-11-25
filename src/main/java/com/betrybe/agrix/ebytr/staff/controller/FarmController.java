package com.betrybe.agrix.ebytr.staff.controller;

import com.betrybe.agrix.ebytr.staff.controller.dto.CropCreationDto;
import com.betrybe.agrix.ebytr.staff.controller.dto.FarmCreationDto;
import com.betrybe.agrix.ebytr.staff.controller.dto.ResponseDto;
import com.betrybe.agrix.ebytr.staff.entity.Crop;
import com.betrybe.agrix.ebytr.staff.entity.Farm;
import com.betrybe.agrix.ebytr.staff.service.CropService;
import com.betrybe.agrix.ebytr.staff.service.FarmService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Farm controller.
 */
@RestController
@RequestMapping("/farms")
public class FarmController {

  @Autowired
  private final FarmService farmService;

  @Autowired
  private final CropService cropService;

  /**
   * Instantiates a new Farm controller.
   *
   * @param farmService the farm service
   * @param cropService the crop service
   */
  public FarmController(FarmService farmService, CropService cropService) {
    this.farmService = farmService;
    this.cropService = cropService;
  }

  /**
   * Create fazenda response entity.
   *
   * @param farmCreationDto the farm creation dto
   * @return the response entity
   */
  @PostMapping
  public ResponseEntity<Farm> createFazenda(@RequestBody FarmCreationDto farmCreationDto) {
    Farm newFarm = farmService.create(farmCreationDto.toEntity());

    ResponseDto<Farm> responseDto = new ResponseDto<>("Fazenda criada com sucesso", newFarm);
    return ResponseEntity.status(HttpStatus.CREATED).body(responseDto.data());
  }

  /**
   * Gets all fazendas.
   *
   * @return the all fazendas
   */
  @GetMapping
  public ResponseEntity<List<Farm>> getAllFazendas() {
    List<Farm> farms = farmService.getAll();
    ResponseDto<List<Farm>> responseDto = new ResponseDto<>("Todas as fazendas listadas",
        farms);
    return ResponseEntity.status(HttpStatus.OK).body(responseDto.data());
  }

  /**
   * Gets by id.
   *
   * @param farmId the farm id
   * @return the by id
   */
  @GetMapping("/{farmId}")
  public ResponseEntity<Farm> getById(@PathVariable Long farmId) {
    Farm farm = farmService.getById(farmId);
    ResponseDto<Farm> responseDto = new ResponseDto<>("Fazenda encontrada com sucesso!",
        farm);
    return ResponseEntity.status(HttpStatus.OK).body(responseDto.data());
  }

  /**
   * Create crop response entity.
   *
   * @param cropCreationDto the crop creation dto
   * @param farmId          the farm id
   * @return the response entity
   */
  @PostMapping("{farmId}/crops")
  public ResponseEntity<Crop> createCrop(
      @RequestBody CropCreationDto cropCreationDto,
      @PathVariable Long farmId
  ) {
    Farm farm = farmService.getById(farmId);
    Crop newCrop = cropService.create(cropCreationDto.toEntity(farm));

    ResponseDto<Crop> responseDto = new ResponseDto<>("Crop criada com sucesso", newCrop);
    return ResponseEntity.status(HttpStatus.CREATED).body(responseDto.data());
  }

  /**
   * Gets crops by farm.
   *
   * @param farmId the farm id
   * @return the crops by farm
   */
  @GetMapping("/{farmId}/crops")
  public ResponseEntity<List<Crop>> getCropsByFarm(@PathVariable Long farmId) {
    Farm farm = farmService.getById(farmId);
    ResponseDto<List<Crop>> responseDto = new ResponseDto<>("Plantaçoes da fazenda" + farmId,
        farm.getCrops());
    return ResponseEntity.status(HttpStatus.OK).body(responseDto.data());
  }

}
