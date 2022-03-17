package com.hcl.parkar.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.hcl.parkar.dao.VehicleRepository;
import com.hcl.parkar.model.VehicleEntity;
import com.hcl.parkar.service.VehicleService;

public class VehicleServiceImpl implements VehicleService {
	@Autowired
	private VehicleRepository vehicleRepository;

	@Override
	public VehicleEntity getVehicleEntity(int vehicleNumber) {

		if (0 != vehicleNumber) {
			Optional<VehicleEntity> vehicleEntity = vehicleRepository.findByVehicleNumber(vehicleNumber);
			if (vehicleEntity.isPresent()) {
				return vehicleEntity.get();
			}
		}
		return null;
	}

	@Override
	public List<VehicleEntity> list() {

		return (List<VehicleEntity>) vehicleRepository.findAll();
	}

	@Override
	public VehicleEntity save(VehicleEntity vehicleEntity) {

		return vehicleRepository.save(vehicleEntity);
	}

	@Override
	public VehicleEntity update(int vehicleNumber, VehicleEntity initialVehicleEntity) {
		if (initialVehicleEntity.getVehicleNumber() != 0) {
			Optional<VehicleEntity> optionalVehicleEntity = vehicleRepository.findByVehicleNumber(vehicleNumber);
			if (optionalVehicleEntity.isPresent()) {
				VehicleEntity vehicleEntity = optionalVehicleEntity.get();
				vehicleEntity.setVehicleNumber(initialVehicleEntity.getVehicleNumber());
				vehicleEntity.setVehicleCategory(initialVehicleEntity.getVehicleCategory());
				vehicleEntity.setVehicleCity(initialVehicleEntity.getVehicleCity());
				vehicleEntity.setVehicleState(initialVehicleEntity.getVehicleState());

				return vehicleRepository.save(vehicleEntity);
			}
		}
		return null;
	}

	@Override
	public Boolean delete(int vehicleNumber) {
		if (0 != vehicleNumber) {
			Optional<VehicleEntity> vehicleEntity = vehicleRepository.findByVehicleNumber(vehicleNumber);

			if (vehicleEntity.isPresent()) {
				vehicleRepository.delete(vehicleEntity.get());
				return true;
			}
		}
		return false;
	}

}
