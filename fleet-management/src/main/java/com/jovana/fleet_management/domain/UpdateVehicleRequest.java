package com.jovana.fleet_management.domain;


public record UpdateVehicleRequest(String licensePlate, String model, int yearMake, double currentMileage) {
}
