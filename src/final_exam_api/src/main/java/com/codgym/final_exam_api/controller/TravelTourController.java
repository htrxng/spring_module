package com.codgym.final_exam_api.controller;

import com.codgym.final_exam_api.dto.TourDto;
import com.codgym.final_exam_api.model.travel_tour_system.Member;
import com.codgym.final_exam_api.model.travel_tour_system.RangeType;
import com.codgym.final_exam_api.model.travel_tour_system.Tour;
import com.codgym.final_exam_api.model.travel_tour_system.TourType;
import com.codgym.final_exam_api.service.impl.MemberService;
import com.codgym.final_exam_api.service.impl.RangeTypeService;
import com.codgym.final_exam_api.service.impl.TourService;
import com.codgym.final_exam_api.service.impl.TourTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/travel-tour")
public class TravelTourController {
    @Autowired
    private MemberService memberService;
    @Autowired
    private TourTypeService tourTypeService;
    @Autowired
    private RangeTypeService rangeTypeService;
    @Autowired
    private TourService tourService;


    @GetMapping("/members")
    public ResponseEntity<List<Member>> getMemberList() {
        List<Member> memberList = this.memberService.findAll();
        if (memberList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(memberList, HttpStatus.OK);
        }
    }
    @GetMapping("/tourTypes")
    public ResponseEntity<List<TourType>> getTourTypeList() {
        List<TourType> tourTypeList = this.tourTypeService.findAll();
        if (tourTypeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(tourTypeList, HttpStatus.OK);
        }
    }
    @GetMapping("/rangeTypes")
    public ResponseEntity<List<RangeType>> getRangeTypeList() {
        List<RangeType> rangeTypeList = this.rangeTypeService.findAll();
        if (rangeTypeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(rangeTypeList, HttpStatus.OK);
        }
    }

    @PostMapping("/tours")
    public ResponseEntity<Tour> createBus(
            @Validated @RequestBody TourDto tourDto,
                                          BindingResult bindingResult) {
        new TourDto().validate(tourDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        } else {
            Tour tour = new Tour();
            BeanUtils.copyProperties(tourDto, tour);
            tourService.save(tour);
            return new ResponseEntity<>(tour, HttpStatus.OK);
        }
    }

    @GetMapping("/tours")
    public ResponseEntity<List<Tour>> getTourList() {
        List<Tour> tourList = this.tourService.findAll();
        if (tourList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(tourList, HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTour(@PathVariable Integer id) {
        Tour tour = this.tourService.findById(id);
        if (tour == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            boolean check = this.tourService.deleteById(id);
            if(check) {
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
    }

}
