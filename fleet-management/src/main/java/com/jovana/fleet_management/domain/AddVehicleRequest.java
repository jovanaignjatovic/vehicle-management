package com.jovana.fleet_management.domain;

public record AddVehicleRequest(String licensePlate, String model, int yearMake, double currentMileage) {
}
