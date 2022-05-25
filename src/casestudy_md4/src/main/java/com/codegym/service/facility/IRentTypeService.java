package com.codegym.service.facility;

import com.codegym.model.facility.RentType;

import java.util.List;

public interface IRentTypeService {
    List<RentType> findAll();
}
