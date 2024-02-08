package com.example.zoomcar.dtos;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class VehicleResponseDto {
    private Long vehicleId;
    private String vehicleName;
    private String vehicleType;
    private String city;
}
