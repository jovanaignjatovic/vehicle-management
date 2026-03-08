package com.jovana.fleet_management.domain.dto;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record AddVehicleDto(

        @NotBlank(message = ERROR_MESSAGE_LICENSE_LENGTH)
        @Length(max = 8, message = ERROR_MESSAGE_LICENSE_LENGTH)
        String licensePlate,

        @NotBlank(message = ERROR_MESSAGE_MODEL_LENGTH)
        @Length(max = 17, message = ERROR_MESSAGE_MODEL_LENGTH)
        String model,

        @Min(value = 1900, message = ERROR_MESSAGE_YEAR_LENGTH)
        int yearMake,

        @Max(value = 2026, message = ERROR_MESSAGE_MILE_LENGTH)
        double currentMileage) {

        private static final String ERROR_MESSAGE_LICENSE_LENGTH =
             "License plate must be between 1 to 8 characters";

        private static final String ERROR_MESSAGE_MODEL_LENGTH =
            "Car model must must have maximum 17 characters";

        private static final String ERROR_MESSAGE_YEAR_LENGTH =
            "Invalid year. Year can have 4 numbers";

        private static final String ERROR_MESSAGE_MILE_LENGTH =
            "Please enter a valid number";

}
