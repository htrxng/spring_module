package com.codgym.final_exam_api.service;

import com.codgym.final_exam_api.model.travel_tour_system.Tour;

import java.util.List;

public interface ITourService {
    List<Tour> findAll();

    void save(Tour tour);

    Tour findById(Integer id);

    boolean deleteById(Integer id);
}
