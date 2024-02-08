package com.example.zoomcar.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Location extends BaseModel{
    private String name;
    private String address;
    private double latitude;
    private double longitude;
}
