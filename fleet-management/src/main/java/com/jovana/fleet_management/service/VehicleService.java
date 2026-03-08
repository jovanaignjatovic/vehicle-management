package com.jovana.fleet_management.service;

import com.jovana.fleet_management.domain.AddVehicleRequest;
import com.jovana.fleet_management.domain.UpdateVehicleRequest;
import com.jovana.fleet_management.domain.entity.Vehicle;

import java.util.List;
import java.util.UUID;

public interface VehicleService {

    Vehicle addVehicle(AddVehicleRequest request);
    List<Vehicle> listVehicles();
    Vehicle updateVehicle(UUID vehicleId, UpdateVehicleRequest request);
    void deleteVehicle(UUID vehicleId);
}
