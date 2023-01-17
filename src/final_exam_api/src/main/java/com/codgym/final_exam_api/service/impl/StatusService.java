package com.codgym.final_exam_api.service.impl;

import com.codgym.final_exam_api.model.travel_tour_system.Status;
import com.codgym.final_exam_api.repository.travel_tour_system_repo.IStatusRepository;
import com.codgym.final_exam_api.service.IStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService implements IStatusService {
    @Autowired
    private IStatusRepository statusRepository;

    @Override
    public List<Status> findAll() {
        return statusRepository.findAll();
    }
}
