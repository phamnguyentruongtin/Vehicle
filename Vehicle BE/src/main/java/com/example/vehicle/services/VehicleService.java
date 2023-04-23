package com.example.vehicle.services;

import com.example.vehicle.models.Vehicle;
import com.example.vehicle.repository.IVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VehicleService implements IVehicleService{
    @Autowired
    private IVehicleRepository iVehicleRepository;
    @Override
    public Page<Vehicle> getAll(String fromTo,String goTo,String owner,PageRequest pageRequest) {
        Page<Vehicle> getAll =  iVehicleRepository.getAllWithPage(fromTo,goTo,owner,pageRequest);
        return  getAll;
    }

    @Override
    public List<Vehicle> searchAPI(String fromTo, String goTO, String owner) {
        return iVehicleRepository.searchAPI(fromTo,goTO,owner);
    }

    @Override
        public List<Vehicle>getAllNoPage() {
            return iVehicleRepository.findAll();
        }
    @Override
    public void save(Vehicle vehicle) {
        iVehicleRepository.save(vehicle);
    }

    @Override
    public void delete(Long id) {
     Vehicle vehicle = iVehicleRepository.findById(id).get();
        iVehicleRepository.delete(vehicle);
    }

    @Override
    public Vehicle findById(Long id) {
        return iVehicleRepository.findById(id).get();
    }
}
