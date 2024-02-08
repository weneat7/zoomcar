package com.example.zoomcar.dtos;

import com.example.zoomcar.models.User;
import com.example.zoomcar.models.Vehicle;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BookingRequestDto {
    private User user;
    private Long vehicleId;
    private Date startDate;
    private Date endDate;
}
