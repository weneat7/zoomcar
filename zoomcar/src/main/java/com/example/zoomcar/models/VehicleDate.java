package com.example.zoomcar.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

@Getter
@Setter
@Entity
public class VehicleDate extends BaseModel {
    @ManyToOne
    private Vehicle vehicle;
    private String startDate;
    private String endDate;
    @Enumerated(EnumType.ORDINAL)
    private VehicleStatus vehicleStatus;
}
