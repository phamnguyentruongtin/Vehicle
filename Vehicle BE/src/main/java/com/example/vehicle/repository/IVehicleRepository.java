package com.example.vehicle.repository;

import com.example.vehicle.models.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehicleRepository  extends JpaRepository<Vehicle, Long> {
    @Query(value = "select * from vehicle where from_to like %?% and go_to like %?% and house_of_vehicle like %?%",nativeQuery = true)
    Page<Vehicle> getAllWithPage(String fromTo,String goTO,String owner,PageRequest pageRequest);
    @Query(value = "select * from vehicle where from_to like %?% and go_to like %?% and house_of_vehicle like %?%",nativeQuery = true)
    List<Vehicle> searchAPI(String fromTo, String goTO, String owner);
}
