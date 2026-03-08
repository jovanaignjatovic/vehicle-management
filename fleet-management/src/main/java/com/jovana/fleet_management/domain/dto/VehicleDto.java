package com.jovana.fleet_management.domain.dto;

import java.util.UUID;

public record VehicleDto(UUID id, String licensePlate, String model, int yearMake, double currentMileage) {
}
