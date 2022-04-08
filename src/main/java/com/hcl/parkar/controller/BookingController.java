package com.hcl.parkar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hcl.parkar.model.BookingEntity;

import com.hcl.parkar.service.BookingService;

@Controller
@RequestMapping("v1/api/booking")
public class BookingController {
	@Autowired
	private BookingService bookingService;

	@RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<BookingEntity> save(@RequestBody BookingEntity bookingEntity) {
		BookingEntity bookingResult = bookingService.save(bookingEntity);
		ResponseEntity<BookingEntity> responseEntity = new ResponseEntity<BookingEntity>(bookingResult,
				HttpStatus.CREATED);
		return responseEntity;
	}

	@RequestMapping(value = "/{bookingId}", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
	public ResponseEntity<BookingEntity> get(@PathVariable int bookingId) {
		BookingEntity bookingResult = bookingService.getBookingEntity(bookingId);
		ResponseEntity<BookingEntity> responseEntity = new ResponseEntity<BookingEntity>(bookingResult, HttpStatus.OK);
		return responseEntity;
	}

	@RequestMapping(value = "/{bookingId}", method = RequestMethod.PATCH, consumes = "application/json", produces = "application/json")
	public ResponseEntity<BookingEntity> update(@PathVariable int bookingId, @RequestBody BookingEntity bookingEntity) {
		BookingEntity bookingResult = bookingService.update(bookingId, bookingEntity);
		ResponseEntity<BookingEntity> responseEntity = new ResponseEntity<BookingEntity>(bookingResult, HttpStatus.OK);
		return responseEntity;
	}

	@RequestMapping(value = "/{bookingId}", method = RequestMethod.DELETE, consumes = "application/json", produces = "application/json")
	public ResponseEntity<Boolean> delete(@PathVariable int bookingId) {
		Boolean isDeleted = bookingService.delete(bookingId);
		ResponseEntity<Boolean> responseEntity = new ResponseEntity<Boolean>(isDeleted, HttpStatus.OK);
		return responseEntity;
	}

	@RequestMapping(value = "", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
	public ResponseEntity<List<BookingEntity>> list() {
		List<BookingEntity> bookingResult = bookingService.list();
		ResponseEntity<List<BookingEntity>> responseEntity = new ResponseEntity<>(bookingResult, HttpStatus.OK);
		return responseEntity;
	}
}
