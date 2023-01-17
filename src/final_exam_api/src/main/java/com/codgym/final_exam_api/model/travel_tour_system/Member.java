package com.codgym.final_exam_api.model.travel_tour_system;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIgnoreProperties({"tourList","registerFormList"})
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer memberId;
    private String memberName;
    private String birthDate;
    private String address;
    private String email;
    private String phone;
    private Integer gender;
    @JsonBackReference(value = "registerFormList")
    @OneToMany(mappedBy = "member")
    private List<RegisterForm> registerFormList;
    @JsonBackReference(value = "tourList")
    @OneToMany(mappedBy = "member")
    private List<Tour> tourList;


    public Member() {
    }

    public List<Tour> getTourList() {
        return tourList;
    }

    public void setTourList(List<Tour> tourList) {
        this.tourList = tourList;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public List<RegisterForm> getRegisterFormList() {
        return registerFormList;
    }

    public void setRegisterFormList(List<RegisterForm> registerFormList) {
        this.registerFormList = registerFormList;
    }
}
