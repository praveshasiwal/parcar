package com.hcl.parkar.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.parkar.dao.BookingRepository;
import com.hcl.parkar.model.BookingEntity;
import com.hcl.parkar.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepository bookingRepository;

	@Override
	@Transactional
	public BookingEntity getBookingEntity(int bookingId) {

		if (0 != bookingId) {
			Optional<BookingEntity> bookingEntity = bookingRepository.findById(bookingId);
			if (bookingEntity.isPresent()) {
				return bookingEntity.get();
			}
		}
		return null;
	}

	@Override
	@Transactional
	public List<BookingEntity> list() {

		return (List<BookingEntity>) bookingRepository.findAll();
	}

	@Override
	@Transactional
	public BookingEntity save(BookingEntity bookingEntity) {

		return bookingRepository.save(bookingEntity);
	}
	@Override
	@Transactional
	public BookingEntity update(int bookingId, BookingEntity initialBookingEntity) {
		if (initialBookingEntity.getBookingId() != 0) {
			Optional<BookingEntity> optionalBookingEntity = bookingRepository.findById(bookingId);
			if (optionalBookingEntity.isPresent()) {
				BookingEntity bookingEntity = optionalBookingEntity.get();
				bookingEntity.setStartTime(initialBookingEntity.getStartTime());
				bookingEntity.setEndTime(initialBookingEntity.getEndTime());
				

				return bookingRepository.save(bookingEntity);
			}
		}
		return null;
	}

	@Override
	@Transactional
	public Boolean delete(int bookingId) {
		if (0 != bookingId) {
			Optional<BookingEntity> bookingEntity = bookingRepository.findById(bookingId);

			if (bookingEntity.isPresent()) {
				bookingRepository.deleteById(bookingId);
				return true;
			}
		}
		return false;
	}

}
