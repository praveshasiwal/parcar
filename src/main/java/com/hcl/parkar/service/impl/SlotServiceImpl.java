package com.hcl.parkar.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hcl.parkar.dao.SlotRepository;
import com.hcl.parkar.model.SlotEntity;
import com.hcl.parkar.service.SlotService;

@Service
public class SlotServiceImpl implements SlotService {
	@Autowired
	private SlotRepository slotRepository;

	@Override
	public SlotEntity getSlotEntity(String slotNumber) {

		if (null != slotNumber) {
			Optional<SlotEntity> slotEntity = slotRepository.findBySlotNumber(slotNumber);
			if (slotEntity.isPresent()) {
				return slotEntity.get();
			}
		}
		return null;
	}

	@Override
	public List<SlotEntity> list() {
		return (List<SlotEntity>) slotRepository.findAll();
	}

	@Override
	public SlotEntity save(SlotEntity slotEntity) {
		return slotRepository.save(slotEntity);
	}

	@Override
	public SlotEntity update(String slotNumber, SlotEntity initialSlotEntity) {
		if (initialSlotEntity.getSlotNumber() != null) {
			Optional<SlotEntity> optionalSlotEntity = slotRepository.findBySlotNumber(slotNumber);

			if (optionalSlotEntity.isPresent()) {
				SlotEntity slotEntity = optionalSlotEntity.get();
				slotEntity.setSlotNumber(initialSlotEntity.getSlotNumber());
				slotEntity.setSlotType(initialSlotEntity.getSlotType());
				slotEntity.setSlotAvailability(initialSlotEntity.getSlotAvailability());
				return slotRepository.save(slotEntity);
			}
		}
		return null;
	}

	@Override
	public Boolean delete(String slotNumber) {
		if (null != slotNumber) {
			Optional<SlotEntity> slotEntity = slotRepository.findBySlotNumber(slotNumber);
			if (slotEntity.isPresent()) {
				slotRepository.delete(slotEntity.get());
				return true;
			}
		}
		return false;
	}

}
