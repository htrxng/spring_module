package com.codgym.final_exam_api.service.impl;

import com.codgym.final_exam_api.model.travel_tour_system.RangeType;
import com.codgym.final_exam_api.repository.travel_tour_system_repo.IRangeTypeRepository;
import com.codgym.final_exam_api.service.IRangeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RangeTypeService implements IRangeTypeService {
    @Autowired
    private IRangeTypeRepository rangeTypeRepository;

    @Override
    public List<RangeType> findAll() {
        return rangeTypeRepository.findAll();
    }
}
