package com.codgym.final_exam_api.service.impl;

import com.codgym.final_exam_api.model.BusWareHouse;
import com.codgym.final_exam_api.repository.IBusWareHouseRepository;
import com.codgym.final_exam_api.service.IBusWareHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusWareHouseService implements IBusWareHouseService {
    @Autowired
    private IBusWareHouseRepository iBusWareHouseRepository;
    @Override
    public List<BusWareHouse> findAllBusWareHouse() {
        return iBusWareHouseRepository.findAll();
    }
}
