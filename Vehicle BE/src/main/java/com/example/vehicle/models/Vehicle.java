package com.example.vehicle.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vehicle {
    @Id
    private Long id;
    private String typeOfVehicle;
    private String houseOfVehicle;
    private String fromTo;
    private String goTo;
    private String phoneNumber;
    private String email;
    private String startTime;
    private String endTime;

    public Vehicle() {
    }

    public Vehicle(Long id, String typeOfVehicle, String houseOfVehicle, String fromTo, String goTo, String phoneNumber, String email, String startTime, String endTime) {
        this.id = id;
        this.typeOfVehicle = typeOfVehicle;
        this.houseOfVehicle = houseOfVehicle;
        this.fromTo = fromTo;
        this.goTo = goTo;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeOfVehicle() {
        return typeOfVehicle;
    }

    public void setTypeOfVehicle(String typeOfVehicle) {
        this.typeOfVehicle = typeOfVehicle;
    }

    public String getHouseOfVehicle() {
        return houseOfVehicle;
    }

    public void setHouseOfVehicle(String houseOfVehicle) {
        this.houseOfVehicle = houseOfVehicle;
    }

    public String getFromTo() {
        return fromTo;
    }

    public void setFromTo(String fromTo) {
        this.fromTo = fromTo;
    }

    public String getGoTo() {
        return goTo;
    }

    public void setGoTo(String goTo) {
        this.goTo = goTo;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
