package com.codgym.final_exam_api.model.travel_tour_system;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties({"tourList"})
public class RangeType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rangeTypeId;
    private String rangeName;
    @JsonBackReference(value = "tourList")
    @OneToMany(mappedBy = "rangeType")
    private List<Tour> tourList;


    public RangeType() {
    }

    public Integer getRangeTypeId() {
        return rangeTypeId;
    }

    public void setRangeTypeId(Integer rangeId) {
        this.rangeTypeId = rangeId;
    }

    public String getRangeName() {
        return rangeName;
    }

    public void setRangeName(String rangeName) {
        this.rangeName = rangeName;
    }

    public List<Tour> getTourList() {
        return tourList;
    }

    public void setTourList(List<Tour> tourList) {
        this.tourList = tourList;
    }
}
