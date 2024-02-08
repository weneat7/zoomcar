package com.example.zoomcar.controllers;

import com.example.zoomcar.dtos.VehicleRequestDto;
import com.example.zoomcar.dtos.VehicleResponseDto;
import com.example.zoomcar.models.City;
import com.example.zoomcar.models.Vehicle;
import com.example.zoomcar.models.VehicleType;
import com.example.zoomcar.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Controller
public class VehicleController {
    private VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService){
        this.vehicleService = vehicleService;
    }

    public List<VehicleResponseDto> getAvailableVehicles(VehicleRequestDto vehicleRequestDto){
        Date startDate = vehicleRequestDto.getStartDate();
        Date endDate = vehicleRequestDto.getEndDate();
        City city = new City();
        city.setName(vehicleRequestDto.getCity());

        List<Vehicle> vehicles = vehicleService.getAllVehicles(startDate, endDate, city, VehicleType.valueOf(vehicleRequestDto.getVehicleType()));
        List<VehicleResponseDto> vehicleResponseDtos = new ArrayList<>();
        for(Vehicle vehicle: vehicles){
            vehicleResponseDtos.add(vehicleService.convertVehicleToVehicleResponseDto(vehicle));
        }
        return vehicleResponseDtos;
    }


}
