package com.example.zoomcar.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class VehicleRequestDto {
    private Date startDate;
    private Date endDate;
    private String city;
    private String vehicleType;
}
