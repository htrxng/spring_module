package com.codegym.service;

import com.codegym.model.Facility;
import com.codegym.repository.IFacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityService implements IFacilityService{
    @Autowired
    private IFacilityRepository iFacilityRepository;
    @Override
    public List<Facility> findAll() {
        return iFacilityRepository.findAll();
    }

    @Override
    public void save(Facility facility) {
        iFacilityRepository.save(facility);
    }
}
