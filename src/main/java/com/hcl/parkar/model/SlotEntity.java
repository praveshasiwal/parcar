package com.hcl.parkar.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@Entity
@Table(name = "slot")
public class SlotEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	@Autowired
	@Id
	@Column(name = "slot_number", nullable = false, length = 50)
	private String slotNumber;
	@Column(name = "slot_type", nullable = false, length = 50)
	private String slotType;
	@Column(name = "slot_availability")
	@Value("true")
	private Boolean slotAvailability;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private VehicleEntity vehicle;

	public String getSlotNumber() {
		return slotNumber;
	}

	public void setSlotNumber(String slotNumber) {
		this.slotNumber = slotNumber;
	}

	public String getSlotType() {
		return slotType;
	}

	public void setSlotType(String slotType) {
		this.slotType = slotType;
	}

	public Boolean getSlotAvailability() {
		return true;
	}

	public void setSlotAvailability(Boolean slotAvailability) {
		this.slotAvailability = slotAvailability;
	}

	public VehicleEntity getVehicle() {
		return vehicle;
	}

	public void setVehicle(VehicleEntity vehicle) {
		this.vehicle = vehicle;
	}

	@Override
	public String toString() {
		return "SlotEntity [slotNumber=" + slotNumber + ", slotType=" + slotType + ", slotAvailability="
				+ slotAvailability + "]";
	}

}
