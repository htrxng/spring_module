package com.codgym.final_exam_api.repository.travel_tour_system_repo;

import com.codgym.final_exam_api.model.travel_tour_system.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITourRepository extends JpaRepository<Tour, Integer> {
    @Query(value = "select * from tour where flag = 1",
          countQuery = "select * from tour where flag = 1",
          nativeQuery = true)
    List<Tour> findAllTour();
}
