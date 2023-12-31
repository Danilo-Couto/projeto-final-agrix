package com.betrybe.agrix.ebytr.staff.controller;

import com.betrybe.agrix.ebytr.staff.controller.dto.FertilizerCreationDto;
import com.betrybe.agrix.ebytr.staff.controller.dto.ResponseDto;
import com.betrybe.agrix.ebytr.staff.entity.Fertilizer;
import com.betrybe.agrix.ebytr.staff.service.FertilizerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Fertilizer controller.
 */
@RestController
@RequestMapping("/fertilizers")
public class FertilizerController {

  @Autowired
  private final FertilizerService fertilizerService;

  /**
   * Instantiates a new Fertilizer controller.
   *
   * @param fertilizerService the fertilizer service
   */
  public FertilizerController(FertilizerService fertilizerService) {
    this.fertilizerService = fertilizerService;
  }

  /**
   * Create ferlizer response entity.
   *
   * @param fertilizerCreationDto the fertilizer creation dto
   * @return the response entity
   */
  @PostMapping
  public ResponseEntity<Fertilizer> createFerlizer(
      @RequestBody FertilizerCreationDto fertilizerCreationDto
  ) {
    Fertilizer newFertilizer = fertilizerService.create(fertilizerCreationDto.toEntity());
    ResponseDto<Fertilizer> responseDto = new ResponseDto<>("Fertilizante criado com sucesso",
        newFertilizer);
    return ResponseEntity.status(HttpStatus.CREATED).body(responseDto.data());
  }

  /**
   * Gets fertilizers.
   *
   * @return the fertilizers
   */
  @GetMapping
  @PreAuthorize("hasAnyRole('ADMIN')")
  public ResponseEntity<List<Fertilizer>> getFertilizers() {
    List<Fertilizer> fertilizers = fertilizerService.getAll();
    ResponseDto<List<Fertilizer>> responseDto = new ResponseDto<>(
        "Fertilizantes encontrado com sucesso", fertilizers);
    return ResponseEntity.status(HttpStatus.OK).body(responseDto.data());
  }


  /**
   * Gets fertilizer by id.
   *
   * @param fertilizerId the fertilizer id
   * @return the fertilizer by id
   */
  @GetMapping("/{fertilizerId}")
  public ResponseEntity<Fertilizer> getFertilizerById(
      @PathVariable Long fertilizerId) {
    Fertilizer fertilizer = fertilizerService.getById(fertilizerId);
    System.out.println(fertilizer);
    ResponseDto<Fertilizer> responseDto = new ResponseDto<>("Fertilizante encontrado com sucesso",
        fertilizer);
    return ResponseEntity.status(HttpStatus.OK).body(responseDto.data());
  }
}
