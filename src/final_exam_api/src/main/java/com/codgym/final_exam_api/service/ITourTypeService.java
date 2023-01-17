package com.codgym.final_exam_api.service;

import com.codgym.final_exam_api.model.travel_tour_system.TourType;

import java.util.List;

public interface ITourTypeService {
    List<TourType> findAll();
}
