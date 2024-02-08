package com.example.zoomcar.repositories;

import com.example.zoomcar.models.City;
import com.example.zoomcar.models.Vehicle;
import com.example.zoomcar.models.VehicleType;
import com.example.zoomcar.services.VehicleService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long>{
    Optional<Vehicle> findById(Long vehicleId);

    @Query("SELECT v FROM Vehicle v WHERE v.city = ?3 AND v.vehicleType = ?4 AND v.bookingDates NOT BETWEEN ?1 AND ?2")
    List<Vehicle> getAllVehicles(Date startDate, Date endDate, City city, VehicleType vehicleType);


}
