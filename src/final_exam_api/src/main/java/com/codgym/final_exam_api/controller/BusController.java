package com.codgym.final_exam_api.controller;

import com.codgym.final_exam_api.dto.BusDto;
import com.codgym.final_exam_api.model.Bus;
import com.codgym.final_exam_api.model.BusWareHouse;
import com.codgym.final_exam_api.service.impl.BusService;
import com.codgym.final_exam_api.service.impl.BusWareHouseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/bus")
public class BusController {
    @Autowired
    private BusService busService;
    @Autowired
    private BusWareHouseService busWareHouseService;

    @GetMapping("/busWareHouses")
    public ResponseEntity<List<BusWareHouse>> getBusWareHouseList() {
        List<BusWareHouse> busWareHouseList = this.busWareHouseService.findAllBusWareHouse();
        if (busWareHouseList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(busWareHouseList, HttpStatus.OK);
        }
    }

    @GetMapping("/buses")
    public ResponseEntity<List<Bus>> getBusList() {
        List<Bus> busList = this.busService.findAllBus();
        if (busList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(busList, HttpStatus.OK);
        }
    }


    @PostMapping("/buses")
    public ResponseEntity<Bus> createBus(@Validated @RequestBody BusDto busDto,
                                         BindingResult bindingResult) {
        new BusDto().validate(busDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        } else {
            Bus bus = new Bus();
            BeanUtils.copyProperties(busDto, bus);
            busService.save(bus);
            return new ResponseEntity<>(bus, HttpStatus.OK);
        }
    }

    @GetMapping("/findBus/{id}")
    public ResponseEntity<Bus> findBusById(@PathVariable Integer id) {
        Bus bus = this.busService.findById(id);
        if (bus == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(bus, HttpStatus.OK);
        }
    }

    @PutMapping("/updateBus/{id}")
    public ResponseEntity<Bus> updateBus(@PathVariable Integer id,
                                         @RequestBody BusDto busDto,
                                         BindingResult bindingResult) {
        new BusDto().validate(busDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        } else {
            Bus bus = this.busService.findById(id);
            BeanUtils.copyProperties(busDto, bus);
            busService.save(bus);
            return new ResponseEntity<>(bus, HttpStatus.OK);
        }
    }

    @DeleteMapping("/deleteBus/{id}")
    public ResponseEntity<Void> deleteBus(@PathVariable Integer id) {
        Bus bus = this.busService.findById(id);
        if (bus == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            this.busService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }

    }
    @GetMapping("/searchingBus")
    public ResponseEntity<List<Bus>> getVehicleList(@RequestParam Optional<String> busWareHouseName,
                                                        @RequestParam Optional<String> busWareHouseId) {
        String name = busWareHouseName.orElse("");
        String id = busWareHouseId.orElse("%");
        List<Bus> busSearchedList = this.busService.searchBy(name,id);
        if (busSearchedList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(busSearchedList, HttpStatus.OK);
        }
    }
}
