package com.jovana.fleet_management.repository;

import com.jovana.fleet_management.domain.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FleetRepository extends JpaRepository<Vehicle, UUID> {

}
