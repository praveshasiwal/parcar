package com.hcl.parkar.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.parkar.dao.VehicleRepository;
import com.hcl.parkar.model.VehicleEntity;
import com.hcl.parkar.service.VehicleService;
@Service
public class VehicleServiceImpl implements VehicleService {
	@Autowired
	private VehicleRepository vehicleRepository;

	@Override
	@Transactional
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
	@Transactional
	public List<VehicleEntity> list() {

		return (List<VehicleEntity>) vehicleRepository.findAll();
	}

	@Override
	@Transactional
	public VehicleEntity save(VehicleEntity vehicleEntity) {

		return vehicleRepository.save(vehicleEntity);
	}

	@Override
	@Transactional
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
	@Transactional
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
