package com.codgym.final_exam_api.dto;

import com.codgym.final_exam_api.model.travel_tour_system.Member;
import com.codgym.final_exam_api.model.travel_tour_system.RangeType;
import com.codgym.final_exam_api.model.travel_tour_system.TourType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class TourDto implements Validator {
    private Integer tourId;
    private String tourName;
    private String address;
    private String startDate;
    private String endDate;
    private String endRegisterDate;
    private int maxPeople;
    private String schedule;
    private String targetPeople;
    private Double cost;
    private boolean flag;
    private TourType tourType;
    private RangeType rangeType;
    private Member member;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }

    public TourDto() {
    }

    public Integer getTourId() {
        return tourId;
    }

    public void setTourId(Integer tourId) {
        this.tourId = tourId;
    }

    public String getTourName() {
        return tourName;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getEndRegisterDate() {
        return endRegisterDate;
    }

    public void setEndRegisterDate(String endRegisterDate) {
        this.endRegisterDate = endRegisterDate;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getTargetPeople() {
        return targetPeople;
    }

    public void setTargetPeople(String targetPeople) {
        this.targetPeople = targetPeople;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public TourType getTourType() {
        return tourType;
    }

    public void setTourType(TourType tourType) {
        this.tourType = tourType;
    }

    public RangeType getRangeType() {
        return rangeType;
    }

    public void setRangeType(RangeType rangeType) {
        this.rangeType = rangeType;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
