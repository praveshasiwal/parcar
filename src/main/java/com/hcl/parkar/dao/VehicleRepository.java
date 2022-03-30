package com.hcl.parkar.dao;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.hcl.parkar.model.VehicleEntity;

@Repository
public interface VehicleRepository extends CrudRepository<VehicleEntity, Integer> {

	Optional<VehicleEntity> findByVehicleNumber(int vehicleNumber);

}