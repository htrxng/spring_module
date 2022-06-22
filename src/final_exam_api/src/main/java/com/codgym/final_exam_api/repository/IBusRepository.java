package com.codgym.final_exam_api.repository;

import com.codgym.final_exam_api.model.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBusRepository extends JpaRepository<Bus, Integer> {
    List<Bus> findAllByBusWareHouse_BusWareHouseNameContaining(String name);

    List<Bus> findAllByBusWareHouse_BusWareHouseNameContainingAndBusWareHouse_BusWareHouseId(String name, int id);
}
