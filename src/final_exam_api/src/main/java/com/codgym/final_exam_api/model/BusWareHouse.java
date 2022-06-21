package com.codgym.final_exam_api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class BusWareHouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer busWareHouseId;
    private String busWareHouseName;
    private String email;
    @JsonBackReference
    @OneToMany(mappedBy = "busWareHouse")
    private List<Bus> busList;

    public BusWareHouse() {
    }

    public BusWareHouse(Integer busWareHouseId, String busWareHouseName, String email, List<Bus> busList) {
        this.busWareHouseId = busWareHouseId;
        this.busWareHouseName = busWareHouseName;
        this.email = email;
        this.busList = busList;
    }

    public Integer getBusWareHouseId() {
        return busWareHouseId;
    }

    public void setBusWareHouseId(Integer busWareHouseId) {
        this.busWareHouseId = busWareHouseId;
    }

    public String getBusWareHouseName() {
        return busWareHouseName;
    }

    public void setBusWareHouseName(String busWareHouseName) {
        this.busWareHouseName = busWareHouseName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Bus> getBusList() {
        return busList;
    }

    public void setBusList(List<Bus> busList) {
        this.busList = busList;
    }
}
