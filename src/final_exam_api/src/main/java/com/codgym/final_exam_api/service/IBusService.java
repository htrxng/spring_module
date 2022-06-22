package com.codgym.final_exam_api.service;

import com.codgym.final_exam_api.model.Bus;

import java.util.List;

public interface IBusService {
    List<Bus> findAllBus();

    Bus save(Bus bus);

    Bus findById(int id);

    void deleteById(Integer id);

    List<Bus> searchBy(String name, String id);
}
