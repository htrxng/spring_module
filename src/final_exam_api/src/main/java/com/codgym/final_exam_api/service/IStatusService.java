package com.codgym.final_exam_api.service;

import com.codgym.final_exam_api.model.travel_tour_system.Status;

import java.util.List;

public interface IStatusService {
    List<Status> findAll();
}
