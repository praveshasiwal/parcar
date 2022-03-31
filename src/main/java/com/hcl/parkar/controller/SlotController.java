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
import com.hcl.parkar.model.SlotEntity;
import com.hcl.parkar.service.SlotService;

@Controller
@RequestMapping("v1/api/slot")
public class SlotController {
	@Autowired
	private SlotService slotService;

	@RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<SlotEntity> save(@RequestBody SlotEntity slotEntity) {
		SlotEntity slotResult = ((SlotService) slotService).save(slotEntity);
		ResponseEntity<SlotEntity> responseEntity = new ResponseEntity<SlotEntity>(slotResult, HttpStatus.CREATED);
		return responseEntity;

	}

	@RequestMapping(value = "/{slotNumber}", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
	public ResponseEntity<SlotEntity> get(@PathVariable String slotNumber) {
		SlotEntity slotResult = slotService.getSlotEntity(slotNumber);
		ResponseEntity<SlotEntity> responseEntity = new ResponseEntity<SlotEntity>(slotResult, HttpStatus.OK);
		return responseEntity;
	}

	@RequestMapping(value = "/{slotNumber}", method = RequestMethod.PATCH, consumes = "application/json", produces = "application/json")
	public ResponseEntity<SlotEntity> update(@PathVariable String slotNumber, @RequestBody SlotEntity SlotEntity) {
		SlotEntity slotResult = slotService.update(slotNumber, SlotEntity);
		ResponseEntity<SlotEntity> responseEntity = new ResponseEntity<SlotEntity>(slotResult, HttpStatus.OK);
		return responseEntity;
	}

	@RequestMapping(value = "/{slotNumber}", method = RequestMethod.DELETE, consumes = "application/json", produces = "application/json")
	public ResponseEntity<Boolean> delete(@PathVariable String slotNumber) {
		Boolean isDeleted = ((SlotService) slotService).delete(slotNumber);
		ResponseEntity<Boolean> responseEntity = new ResponseEntity<Boolean>(isDeleted, HttpStatus.OK);
		return responseEntity;
	}

	@RequestMapping(value = "", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
	public ResponseEntity<List<SlotEntity>> list() {
		List<SlotEntity> slotResults = slotService.list();
		ResponseEntity<List<SlotEntity>> responseEntity = new ResponseEntity<>(slotResults, HttpStatus.OK);
		return responseEntity;
	}

}
