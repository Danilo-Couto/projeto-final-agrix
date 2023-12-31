package com.betrybe.agrix.ebytr.staff.repository;

import com.betrybe.agrix.ebytr.staff.entity.Fertilizer;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * The interface Fertilizer repository.
 */
public interface FertilizerRepository extends JpaRepository<Fertilizer, Long> {

  /**
   * Find fertilizers by crop list.
   *
   * @param id the id
   * @return the list
   */
  @Query(
      value = "SELECT fertilizer.* FROM fertilizer "
          + "JOIN crop_fertilizer as cf ON fertilizer_id = cf.crop_id "
          + "WHERE crop_id = :id",
      nativeQuery = true
  )
  List<Fertilizer> findFertilizersByCrop(@Param("id") Long id);


}
