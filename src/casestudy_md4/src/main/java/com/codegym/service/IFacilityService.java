package com.codegym.service;

import com.codegym.model.Facility;

import java.util.List;

public interface IFacilityService {
    List<Facility> findAll();

    void save(Facility facility);
}
