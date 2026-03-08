package com.jovana.fleet_management.controller;


import com.jovana.fleet_management.domain.AddVehicleRequest;
import com.jovana.fleet_management.domain.UpdateVehicleRequest;
import com.jovana.fleet_management.domain.dto.AddVehicleDto;
import com.jovana.fleet_management.domain.dto.UpdateVehicleDto;
import com.jovana.fleet_management.domain.dto.VehicleDto;
import com.jovana.fleet_management.domain.entity.Vehicle;
import com.jovana.fleet_management.mapper.VehicleMapper;
import com.jovana.fleet_management.service.VehicleService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;
    private final VehicleMapper vehicleMapper;


    public VehicleController(VehicleService vehicleService, VehicleMapper vehicleMapper) {
        this.vehicleService = vehicleService;
        this.vehicleMapper = vehicleMapper;
    }

    @PostMapping
    public ResponseEntity<VehicleDto> createVehicle(
            @Valid @RequestBody AddVehicleDto addVehicleDto){

        AddVehicleRequest addVehicleRequest = vehicleMapper.fromDto(addVehicleDto);
        Vehicle vehicle = vehicleService.addVehicle(addVehicleRequest);
        VehicleDto addedVehicleDto = vehicleMapper.toDto(vehicle);
        return new ResponseEntity<>(addedVehicleDto, HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity<List<VehicleDto>> listVehicles(){
        List<Vehicle> vehicles = vehicleService.listVehicles();
        List<VehicleDto> vehicleDtos = vehicles.stream().map(vehicleMapper::toDto).toList();
        return ResponseEntity.ok(vehicleDtos);
    }

    @PutMapping(path = "/{vehicleId}")
    public ResponseEntity<VehicleDto> updateVehicle(
            @PathVariable UUID vehicleId,
            @Valid @RequestBody VehicleDto updateVehicleDto
    ){
        UpdateVehicleRequest updateVehicleRequest = vehicleMapper.fromDto(updateVehicleDto);
        Vehicle vehicle = vehicleService.updateVehicle(vehicleId, updateVehicleRequest);
        VehicleDto vehicleDto = vehicleMapper.toDto(vehicle);
        return ResponseEntity.ok(vehicleDto);
    }

    @DeleteMapping(path = "/{vehicleId}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable UUID vehicleId){
        vehicleService.deleteVehicle(vehicleId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
