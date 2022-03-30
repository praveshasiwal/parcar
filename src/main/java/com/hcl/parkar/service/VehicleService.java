package com.hcl.parkar.service;

import java.util.List;
import com.hcl.parkar.model.VehicleEntity;

public interface VehicleService {
	public VehicleEntity getVehicleEntity(int vehicleNumber);

	public List<VehicleEntity> list();

	public VehicleEntity save(VehicleEntity vehicleEntity);

	public VehicleEntity update(int vehicleNumber, VehicleEntity vehicleEntity);

	public Boolean delete(int vehicleNumber);

	VehicleEntity update(String vehicleNumber, VehicleEntity initialVehicleEntity);
}