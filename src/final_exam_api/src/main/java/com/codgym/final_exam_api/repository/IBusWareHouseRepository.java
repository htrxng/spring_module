package com.codgym.final_exam_api.repository;

import com.codgym.final_exam_api.model.BusWareHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBusWareHouseRepository extends JpaRepository<BusWareHouse,Integer> {
}
