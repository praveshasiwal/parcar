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
import com.hcl.parkar.model.VehicleEntity;
import com.hcl.parkar.service.VehicleService;
@Controller
@RequestMapping("/v1/api/vehicle")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity<VehicleEntity> save(@RequestBody VehicleEntity vehicleEntity) {
        VehicleEntity vehicleResult = vehicleService.save(vehicleEntity);
        ResponseEntity<VehicleEntity> responseEntity = new ResponseEntity<VehicleEntity>(vehicleResult,
                HttpStatus.CREATED);
        return responseEntity;
    }
    @RequestMapping(value = "/{vehicleNumber}", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
    public ResponseEntity<VehicleEntity> get(@PathVariable String vehicleNumber) {
        VehicleEntity vehicleResult = vehicleService.getVehicleEntity(vehicleNumber);
        ResponseEntity<VehicleEntity> responseEntity = new ResponseEntity<VehicleEntity>(vehicleResult, HttpStatus.OK);
        return responseEntity;
    }
    @RequestMapping(value = "/{vehicleNumber}", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity<VehicleEntity> update(@PathVariable String vehicleName,
            @RequestBody VehicleEntity vehicleEntity) {
        VehicleEntity vehicleResult = vehicleService.save(vehicleEntity);
        ResponseEntity<VehicleEntity> responseEntity = new ResponseEntity<VehicleEntity>(vehicleResult, HttpStatus.OK);
        return responseEntity;
    }
    @RequestMapping(value = "/{vehicleNumber}", method = RequestMethod.DELETE, consumes = "application/json", produces = "application/json")
    public ResponseEntity<Boolean> delete(@PathVariable int vehicleNumber) {
        Boolean isDeleted = vehicleService.delete(vehicleNumber);
        ResponseEntity<Boolean> responseEntity = new ResponseEntity<Boolean>(isDeleted, HttpStatus.OK);
        return responseEntity;
    }
    @RequestMapping(value = "", method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
    public ResponseEntity<List<VehicleEntity>> list() {
        List<VehicleEntity> vehicleResults = vehicleService.list();
        ResponseEntity<List<VehicleEntity>> responseEntity = new ResponseEntity<>(vehicleResults, HttpStatus.OK);
        return responseEntity;
    }
}