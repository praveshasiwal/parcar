package com.hcl.parkar.service;

import java.util.List;

import com.hcl.parkar.model.BookingEntity;

public interface BookingService {

	public BookingEntity getBookingEntity(int bookingId);

	public List<BookingEntity> list();

	public BookingEntity save(BookingEntity bookingEntity);

	public BookingEntity update(int bookingId, BookingEntity bookingEntity);

	public Boolean delete(int bookingId);
}
