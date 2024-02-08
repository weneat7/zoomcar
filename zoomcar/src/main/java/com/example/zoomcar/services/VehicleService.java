package com.example.zoomcar.services;

import com.example.zoomcar.dtos.VehicleResponseDto;
import com.example.zoomcar.models.City;
import com.example.zoomcar.models.Vehicle;
import com.example.zoomcar.models.VehicleType;
import com.example.zoomcar.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class VehicleService {
    private VehicleRepository vehicleRepository;

    @Autowired
    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }



    public boolean isVehicleAvailable(Vehicle vehicle, Date startDate, Date endDate) {
        Date date = vehicle.getBookingDates();

            if(date.after(startDate) && date.before(endDate))
                return false;

        return true;
    }

    public List<Vehicle> getAllVehicles(Date startDate, Date endDate, City city, VehicleType vehicleType){
        return vehicleRepository.getAllVehicles(startDate, endDate, city, vehicleType);
    }

    public VehicleResponseDto convertVehicleToVehicleResponseDto(Vehicle vehicle) {
        return null;
    }
}
