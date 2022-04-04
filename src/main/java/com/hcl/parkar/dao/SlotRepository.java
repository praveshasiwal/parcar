package com.hcl.parkar.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hcl.parkar.model.SlotEntity;

@Repository
public interface SlotRepository extends CrudRepository<SlotEntity, String> {
	Optional<SlotEntity> findBySlotNumber(String slotNumber);
}
