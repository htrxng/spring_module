package com.codgym.final_exam_api.repository;

import com.codgym.final_exam_api.model.Bus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBusRepository extends JpaRepository<Bus, Integer> {


    Page<Bus> getAllBus(Pageable pageable);
}
