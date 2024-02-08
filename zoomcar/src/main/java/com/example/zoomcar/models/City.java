package com.example.zoomcar.models;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class City extends BaseModel{
    private String name;
}
