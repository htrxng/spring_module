package com.codegym.model;

import java.util.Date;

public class HealthDeclarationForm {
    private String fullName;
    private String dateOfBirth;
    private String gender;
    private String idCard;
    private String vehicles;
    private String vehiclesCode;
    private int seatNumberVehicles;
    private String startDate;
    private String endDate;
    private String cityVisited;

    public HealthDeclarationForm() {
    }

    public HealthDeclarationForm(String fullName, String dateOfBirth, String gender, String idCard, String vehicles, String vehiclesCode, int seatNumberVehicles, String startDate, String endDate, String cityVisited) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.idCard = idCard;
        this.vehicles = vehicles;
        this.vehiclesCode = vehiclesCode;
        this.seatNumberVehicles = seatNumberVehicles;
        this.startDate = startDate;
        this.endDate = endDate;
        this.cityVisited = cityVisited;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getVehicles() {
        return vehicles;
    }

    public void setVehicles(String vehicles) {
        this.vehicles = vehicles;
    }

    public String getVehiclesCode() {
        return vehiclesCode;
    }

    public void setVehiclesCode(String vehiclesCode) {
        this.vehiclesCode = vehiclesCode;
    }

    public int getSeatNumberVehicles() {
        return seatNumberVehicles;
    }

    public void setSeatNumberVehicles(int seatNumberVehicles) {
        this.seatNumberVehicles = seatNumberVehicles;
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

    public String getCityVisited() {
        return cityVisited;
    }

    public void setCityVisited(String cityVisited) {
        this.cityVisited = cityVisited;
    }

}
