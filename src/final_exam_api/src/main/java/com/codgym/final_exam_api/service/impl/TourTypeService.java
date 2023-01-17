package com.codgym.final_exam_api.service.impl;

import com.codgym.final_exam_api.model.travel_tour_system.TourType;
import com.codgym.final_exam_api.repository.travel_tour_system_repo.ITourTypeRepository;
import com.codgym.final_exam_api.service.ITourTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourTypeService implements ITourTypeService {
    @Autowired
    private ITourTypeRepository tourTypeRepository;

    @Override
    public List<TourType> findAll() {
        return tourTypeRepository.findAll();
    }
}
