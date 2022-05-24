package com.codegym.repository;

import com.codegym.model.Facility;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFacilityRepository extends JpaRepository<Facility,Integer> {
}
