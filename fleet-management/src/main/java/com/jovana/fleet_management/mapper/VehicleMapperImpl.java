package com.jovana.fleet_management.mapper;

import com.jovana.fleet_management.domain.AddVehicleRequest;
import com.jovana.fleet_management.domain.UpdateVehicleRequest;
import com.jovana.fleet_management.domain.dto.AddVehicleDto;
import com.jovana.fleet_management.domain.dto.VehicleDto;
import com.jovana.fleet_management.domain.entity.Vehicle;
import org.springframework.stereotype.Component;

@Component
public class VehicleMapperImpl implements VehicleMapper{

    @Override
    public AddVehicleRequest fromDto(AddVehicleDto dto) {
        return new AddVehicleRequest(dto.licensePlate(), dto.model(), dto.yearMake(), dto.currentMileage());
    }

    @Override
    public VehicleDto toDto(Vehicle vehicle) {
        return new VehicleDto(vehicle.getId(), vehicle.getLicensePlate(), vehicle.getModel(),
                vehicle.getYearMake(), vehicle.getCurrentMileage());
    }

    @Override
    public UpdateVehicleRequest fromDto(VehicleDto dto) {
        return new UpdateVehicleRequest(dto.licensePlate(), dto.model(), dto.yearMake(), dto.currentMileage());
    }
}
