package com.hcl.parkar.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vehicle")
public class VehicleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "vehicle_number", nullable = false, length = 30)
	private int vehicleNumber;
	@Column(name = "vehicle_category", nullable = false, length = 10)
	private String vehicleCategory;
	@Column(name = "vehicle_city", nullable = false, length = 50)
	private String vehicleCity;
	@Column(name = "vehicle_state", nullable = false, length = 50)
	private String vehicleState;

	@ManyToOne
	@JoinColumn(name = "userId")
	private UserEntity user;

	public int getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(int vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getVehicleCategory() {
		return vehicleCategory;
	}

	public void setVehicleCategory(String vehicleCategory) {
		this.vehicleCategory = vehicleCategory;
	}

	public String getVehicleCity() {
		return vehicleCity;
	}

	public void setVehicleCity(String vehicleCity) {
		this.vehicleCity = vehicleCity;
	}

	public String getVehicleState() {
		return vehicleState;
	}

	public void setVehicleState(String vehicleState) {
		this.vehicleState = vehicleState;
	}

	@Override
	public String toString() {
		return "VehicleEntity [vehicleNumber=" + vehicleNumber + ", vehicleCategory=" + vehicleCategory
				+ ", vehicleCity=" + vehicleCity + ", vehicleState=" + vehicleState + "]";
	}

}