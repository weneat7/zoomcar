package com.example.zoomcar.dtos;

import com.example.zoomcar.models.BookingStatus;
import com.example.zoomcar.models.User;
import com.example.zoomcar.models.Vehicle;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BookingResponseDto {
    private User user;
    private Vehicle vehicle;
    private Date startDate;
    private Date endDate;
}
