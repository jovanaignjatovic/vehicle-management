package com.jovana.fleet_management.exception;

import java.util.UUID;

public class VehicleNotFound extends RuntimeException {

    private UUID id;

    public VehicleNotFound(UUID id) {
        super(
                String.format("Vehicle with ID %s doesn't exist", id));
        this.id = id;
    }

    public UUID getId(){
        return id;
    }
}
