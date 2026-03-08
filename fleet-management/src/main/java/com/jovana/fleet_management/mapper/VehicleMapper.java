package com.jovana.fleet_management.mapper;

import com.jovana.fleet_management.domain.AddVehicleRequest;
import com.jovana.fleet_management.domain.UpdateVehicleRequest;
import com.jovana.fleet_management.domain.dto.AddVehicleDto;
import com.jovana.fleet_management.domain.dto.VehicleDto;
import com.jovana.fleet_management.domain.entity.Vehicle;

public interface VehicleMapper {

    AddVehicleRequest fromDto(AddVehicleDto dto);

    VehicleDto toDto(Vehicle vehicle);

    UpdateVehicleRequest fromDto(VehicleDto dto);
}
