package com.hcl.parkar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vehicle")
public class VehicleEntity {
	@Id
	@Column(nullable = false, unique = true, length = 30)
	private int vehicleid;
	@Column(nullable = false, length = 10)
	private String vehiclecategory;
	@Column(nullable = false, length = 50)
	private String vehiclecity;
	@Column(nullable = false, length = 50)
	private String vehiclestate;

	public int getVehicleid() {
		return vehicleid;
	}

	public void setVehicleid(int vehicleid) {
		this.vehicleid = vehicleid;
	}

	public String getVehiclecategory() {
		return vehiclecategory;
	}

	public void setVehiclecategory(String vehiclecategory) {
		this.vehiclecategory = vehiclecategory;
	}

	public String getVehiclecity() {
		return vehiclecity;
	}

	public void setVehiclecity(String vehiclecity) {
		this.vehiclecity = vehiclecity;
	}

	public String getVehiclestate() {
		return vehiclestate;
	}

	public void setVehiclestate(String vehiclestate) {
		this.vehiclestate = vehiclestate;
	}

	@Override
	public String toString() {
		return "VehicleEntity [vehicleid=" + vehicleid + ", vehiclecategory=" + vehiclecategory + ", vehiclecity="
				+ vehiclecity + ", vehiclestate=" + vehiclestate + "]";
	}
}
