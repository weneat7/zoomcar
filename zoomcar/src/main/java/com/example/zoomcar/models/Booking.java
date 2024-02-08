package com.example.zoomcar.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
public class Booking extends BaseModel{
    @ManyToOne
    private Vehicle vehicle;
    @ManyToOne
    private User renter;
    private Date startDate;
    private Date endDate;
    private BookingStatus bookingStatus;

    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    private List<Enhancements> enhancements;
}
