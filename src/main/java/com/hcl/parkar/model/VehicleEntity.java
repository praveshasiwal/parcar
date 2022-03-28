package com.hcl.parkar.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
	@Column(name = "vehicle_State", nullable = false, length = 50)
	private String vehicleState;
	
//    @ManyToMany
//    @JoinTable(name="VEHICLE_USER", joinColumns = {@JoinColumn(name = "vehicle_number")}, inverseJoinColumns = {@JoinColumn(name = "user_id")})
//	private List<UserEntity> users = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name= "User_ID")
	private UserEntity userEntity;

	@OneToOne
	private BookingEntity bookings;
	
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

//	public List<UserEntity> getUsers() {
//		return users;
//	}
//
//	public void setUsers(List<UserEntity> users) {
//		this.users = users;
//	}
	
//	public UserEntity getUserEntity() {
//		return userEntity;
//	}
//	
//	public void setUserEntity(UserEntity userEntity) {
//		this.userEntity = userEntity;
//	}
	
	public BookingEntity getBookings() {
		return bookings;
	}
	
	public void setBookings(BookingEntity bookings) {
		this.bookings = bookings;
	}
	
	@Override
	public String toString() {
		return "VehicleEntity [vehicleNumber=" + vehicleNumber + ", vehicleCategory=" + vehicleCategory
				+ ", vehicleCity=" + vehicleCity + ", vehicleState=" + vehicleState + "]";
	}



}