package com.codgym.final_exam_api.service;

import com.codgym.final_exam_api.model.Bus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBusService {
    List<Bus> findAllBus();

    Bus save(Bus bus);

    Bus findById(int id);

    void deleteById(Integer id);
    Page<Bus> getAllBus(Pageable pageable);
}
