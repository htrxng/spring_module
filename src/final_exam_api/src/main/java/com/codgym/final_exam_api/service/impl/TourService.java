package com.codgym.final_exam_api.service.impl;

import com.codgym.final_exam_api.model.travel_tour_system.Tour;
import com.codgym.final_exam_api.repository.travel_tour_system_repo.ITourRepository;
import com.codgym.final_exam_api.service.ITourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourService implements ITourService {
    @Autowired
    private ITourRepository tourRepository;

    @Override
    public List<Tour> findAll() {
        return tourRepository.findAllTour();
    }

    @Override
    public void save(Tour tour) {
        this.tourRepository.save(tour);
    }

    @Override
    public Tour findById(Integer id) {
        return this.tourRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteById(Integer id) {
        Tour tour = this.findById(id);
        if(tour == null) {
            return false;
        } else {
            tour.setFlag(false);
            this.tourRepository.save(tour);
            return true;
        }
    }
}
