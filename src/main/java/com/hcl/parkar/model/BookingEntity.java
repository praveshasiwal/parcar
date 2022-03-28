package com.hcl.parkar.model;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Bookings", uniqueConstraints = @UniqueConstraint(columnNames = { "bookingId" }))

public class BookingEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingId;
	
	@Column(name = "Start_Time", nullable = false, length = 15)	
	private LocalTime startTime;
	
	@Column(name = "End_Time", nullable = false, length = 15)
	private LocalTime endTime;
	
	@Column(name = "Duration", nullable = false, length = 15)
	private LocalTime duration;
	
	@Column(name = "Booking_Date", nullable = false, length = 15)
	private Date bookingDate;
	
	 enum BookingStatus { Inprogress , Completed; }
	 
	 @OneToOne(mappedBy = "bookings")
	 private VehicleEntity vehicleEntity;
	
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public LocalTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}
	public LocalTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}
	public LocalTime getDuration() {
		return duration;
	}
	public void setDuration(LocalTime duration) {
		this.duration = duration;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	
	
	
	

}
