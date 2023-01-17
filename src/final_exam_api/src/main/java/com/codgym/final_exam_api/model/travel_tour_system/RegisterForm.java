package com.codgym.final_exam_api.model.travel_tour_system;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class RegisterForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer registerFormId;
    private Integer quantityPeople;
    @ManyToOne
    @JoinColumn(name = "member_id", referencedColumnName = "memberId")
    private Member member;
    @ManyToOne
    @JoinColumn(name = "tour_id", referencedColumnName = "tourId")
    private Tour tour;
    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "statusId")
    private Status status;

    public RegisterForm() {
    }

    public Integer getRegisterFormId() {
        return registerFormId;
    }

    public void setRegisterFormId(Integer registerFormId) {
        this.registerFormId = registerFormId;
    }

    public Integer getQuantityPeople() {
        return quantityPeople;
    }

    public void setQuantityPeople(Integer quantityPeople) {
        this.quantityPeople = quantityPeople;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
