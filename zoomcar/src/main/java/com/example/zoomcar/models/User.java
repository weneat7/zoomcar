package com.example.zoomcar.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class User extends BaseModel {
    private String name;
    private String email;
    private String password;
    @ManyToMany
    List<Vehicle> rentedVehicles;
    @OneToMany
    List<Vehicle> ownedVehicles;
}
