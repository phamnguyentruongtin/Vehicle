package com.example.vehicle.controller;

import com.example.vehicle.models.Vehicle;
import com.example.vehicle.services.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
public class VehicleController {
    @Autowired
    private IVehicleService iVehicleService;

    @GetMapping("getallvehicle")
    public ResponseEntity<List<Vehicle>> getAllAPI(@RequestParam(name = "page") int page,
                                                   @RequestParam(defaultValue = "")String fromTo,
                                                   @RequestParam(defaultValue = "")String goTo,
                                                   @RequestParam(defaultValue = "")String owner) {
        Page<Vehicle> vehicleList = iVehicleService.getAll(fromTo,goTo,owner,PageRequest.of(page, 3));
        return new ResponseEntity<List<Vehicle>>(vehicleList.getContent(), HttpStatus.OK);
    }
    @GetMapping("searchvehicle")
    public ResponseEntity<List<Vehicle>> searchAPI(
                                                   @RequestParam(defaultValue = "")String fromTo,
                                                   @RequestParam(defaultValue = "")String goTo,
                                                   @RequestParam(defaultValue = "")String owner) {
        List<Vehicle> vehicleList = iVehicleService.searchAPI(fromTo,goTo,owner);
        return new ResponseEntity<List<Vehicle>>(vehicleList, HttpStatus.OK);
    }

    @PutMapping("edit/{id}")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable Long id, @RequestBody Vehicle vehicle) {
        iVehicleService.save(vehicle);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("findbyid/{id}")
    public ResponseEntity<Vehicle> getVehicle(@PathVariable("id") Long id) {
        return new ResponseEntity<Vehicle>(iVehicleService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Vehicle> deleteVehicle(@PathVariable("id") Long id) {
        this.iVehicleService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<Vehicle> create(@RequestBody Vehicle vehicle) {
        this.iVehicleService.save(vehicle);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("getallnopage")
    public ResponseEntity<List<Vehicle>> getAllNoPage() {
        if (this.iVehicleService.getAllNoPage() == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Vehicle>>(iVehicleService.getAllNoPage(), HttpStatus.OK);

    }

}
