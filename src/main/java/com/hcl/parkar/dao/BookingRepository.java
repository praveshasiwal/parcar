package com.hcl.parkar.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hcl.parkar.model.BookingEntity;

@Repository
public interface BookingRepository extends CrudRepository<BookingEntity, Integer> {

	Optional<BookingEntity> findById(int bookingId);
}
