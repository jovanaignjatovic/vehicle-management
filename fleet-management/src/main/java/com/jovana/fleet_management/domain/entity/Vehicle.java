package com.jovana.fleet_management.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "vehicles")
@Data
public class Vehicle {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "license", updatable = true, unique = true, nullable = false)
    private String licensePlate;

    @Column(name = "model", nullable = false, updatable = false)
    private String model;

    @Column(name = "year_of_making", updatable = false, nullable = false)
    private int yearMake;

    @Column(name = "current_mileage", updatable = true, nullable = false)
    private double currentMileage;

    public UUID getId() {
        return id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getModel() {
        return model;
    }

    public int getYearMake() {
        return yearMake;
    }

    public double getCurrentMileage() {
        return currentMileage;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYearMake(int yearMake) {
        this.yearMake = yearMake;
    }

    public void setCurrentMileage(double currentMileage) {
        this.currentMileage = currentMileage;
    }

    public Vehicle(UUID id, String licensePlate, String model, int yearMake, double currentMileage) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.model = model;
        this.yearMake = yearMake;
        this.currentMileage = currentMileage;
    }

    public Vehicle(){

    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(id, vehicle.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
