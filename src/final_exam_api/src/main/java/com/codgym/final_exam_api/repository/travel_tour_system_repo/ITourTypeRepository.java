package com.codgym.final_exam_api.repository.travel_tour_system_repo;

import com.codgym.final_exam_api.model.travel_tour_system.TourType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITourTypeRepository extends JpaRepository<TourType, Integer> {
}
