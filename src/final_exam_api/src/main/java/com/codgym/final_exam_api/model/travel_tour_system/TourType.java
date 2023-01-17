package com.codgym.final_exam_api.model.travel_tour_system;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties({"tourList"})
public class TourType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tourTypeId;
    private String tourTypeName;

    @JsonBackReference(value = "tourList")
    @OneToMany(mappedBy = "tourType")
    private List<Tour> tourList;

    public TourType() {
    }

    public Integer getTourTypeId() {
        return tourTypeId;
    }

    public void setTourTypeId(Integer tourTypeId) {
        this.tourTypeId = tourTypeId;
    }

    public String getTourTypeName() {
        return tourTypeName;
    }

    public void setTourTypeName(String tourTypeName) {
        this.tourTypeName = tourTypeName;
    }

    public List<Tour> getTourList() {
        return tourList;
    }

    public void setTourList(List<Tour> tourList) {
        this.tourList = tourList;
    }
}
