package com.example.vehicle.services;

import com.example.vehicle.models.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IVehicleService {
  Page<Vehicle> getAll(String fromTo,String goTo,String owner,PageRequest pageRequest);
  List<Vehicle> searchAPI(String fromTo, String goTO, String owner);
  void save(Vehicle vehicle);
  void delete(Long id);
  public List<Vehicle>getAllNoPage();
  Vehicle findById(Long id);

}
