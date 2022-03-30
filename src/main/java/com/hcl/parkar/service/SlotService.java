package com.hcl.parkar.service;

import java.util.List;

import com.hcl.parkar.model.SlotEntity;

public interface SlotService {


	public SlotEntity getSlotEntity(String slotNumber);

	public List<SlotEntity> list();

	public SlotEntity save(SlotEntity slotEntity);

	public SlotEntity update(String slotNumber, SlotEntity slotEntity);

	public Boolean delete(String slotNumber);

}
