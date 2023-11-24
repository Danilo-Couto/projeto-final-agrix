package com.betrybe.agrix.ebytr.staff.controller;

import com.betrybe.agrix.ebytr.staff.controller.dto.FertilizerCreationDto;
import com.betrybe.agrix.ebytr.staff.controller.dto.ResponseDto;
import com.betrybe.agrix.ebytr.staff.entity.Fertilizer;
import com.betrybe.agrix.ebytr.staff.service.FertilizerService;
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

@RestController
@RequestMapping("/fertilizers")
public class FertilizerController {

  @Autowired
  private final FertilizerService fertilizerService;

  public FertilizerController(FertilizerService fertilizerService) {
    this.fertilizerService = fertilizerService;
  }

  @PostMapping
  public ResponseEntity<Fertilizer> createFerlizer(
      @RequestBody FertilizerCreationDto fertilizerCreationDto
  ) {
    Fertilizer newFertilizer = fertilizerService.create(fertilizerCreationDto.toEntity());
    ResponseDto<Fertilizer> responseDto = new ResponseDto<>("Fertilizante criado com sucesso",
        newFertilizer);
    return ResponseEntity.status(HttpStatus.CREATED).body(responseDto.data());
  }

  @GetMapping
  public ResponseEntity<List<Fertilizer>> getFertilizers() {
    List<Fertilizer> fertilizers = fertilizerService.getAll();
    ResponseDto<List<Fertilizer>> responseDto = new ResponseDto<>(
        "Fertilizantes encontrado com sucesso", fertilizers);
    return ResponseEntity.status(HttpStatus.OK).body(responseDto.data());
  }


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
