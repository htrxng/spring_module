package com.codgym.final_exam_api.model.travel_tour_system;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties({"registerFormList"})
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer statusId;
    private String statusName;
    @JsonBackReference(value = "registerFormList")
    @OneToMany(mappedBy = "status")
    private List<RegisterForm> registerFormList;

    public Status() {
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public List<RegisterForm> getRegisterFormList() {
        return registerFormList;
    }

    public void setRegisterFormList(List<RegisterForm> registerFormList) {
        this.registerFormList = registerFormList;
    }
}
