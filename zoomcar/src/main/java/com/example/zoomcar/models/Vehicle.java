package com.example.zoomcar.models;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Vehicle extends BaseModel{
    private String name;
    private VehicleType vehicleType;
    private VehicleStatus vehicleStatus;

    @ManyToOne
    private City city;

    @ManyToOne
    private Location location;

    @ManyToOne
    private User owner;


    private Date bookingDates;
}
