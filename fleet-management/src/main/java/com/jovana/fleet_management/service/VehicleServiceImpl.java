package com.jovana.fleet_management.service;

import com.jovana.fleet_management.domain.AddVehicleRequest;
import com.jovana.fleet_management.domain.UpdateVehicleRequest;
import com.jovana.fleet_management.domain.entity.Vehicle;
import com.jovana.fleet_management.exception.VehicleNotFound;
import com.jovana.fleet_management.repository.FleetRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
public class VehicleServiceImpl implements VehicleService{

    private final FleetRepository fleetRepository;

    public VehicleServiceImpl(FleetRepository fleetRepository) {
        this.fleetRepository = fleetRepository;
    }

    @Override
    public Vehicle addVehicle(AddVehicleRequest request) {

        Vehicle vehicle = new Vehicle(null, request.licensePlate(), request.model(),
                request.yearMake(), request.currentMileage());

        return fleetRepository.save(vehicle);
    }

    @Override
    public List<Vehicle> listVehicles() {
        return fleetRepository.findAll();
    }

    @Override
    public Vehicle updateVehicle(UUID vehicleId, UpdateVehicleRequest request) {
        Vehicle vehicle = fleetRepository.findById(vehicleId)
                .orElseThrow(() -> new VehicleNotFound(vehicleId));

        vehicle.setLicensePlate(request.licensePlate());
        vehicle.setModel(request.model());
        vehicle.setYearMake(request.yearMake());
        vehicle.setCurrentMileage(request.currentMileage());

        return fleetRepository.save(vehicle);
    }

    @Override
    public void deleteVehicle(UUID vehicleId) {
        if (!fleetRepository.existsById(vehicleId)) {
            throw new VehicleNotFound(vehicleId);
        }
        fleetRepository.deleteById(vehicleId);
    }
}
