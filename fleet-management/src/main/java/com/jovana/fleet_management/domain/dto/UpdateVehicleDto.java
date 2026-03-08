package com.jovana.fleet_management.domain.dto;
import jakarta.validation.constraints.*;


public record UpdateVehicleDto(

        @NotBlank(message = "License plate is required for update")
        @Size(max = 8, message = "License plate too long")
        String licensePlate,

        @Size(max = 17, message = "Model name too long")
        String model,

        @Min(value = 1900, message = "Year must be valid")
        int yearMake,

        @Positive(message = "Mileage must be a positive number")
        double currentMileage)  {
}
