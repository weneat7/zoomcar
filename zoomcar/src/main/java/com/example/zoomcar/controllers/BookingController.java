package com.example.zoomcar.controllers;

import com.example.zoomcar.dtos.BookingRequestDto;
import com.example.zoomcar.dtos.BookingResponseDto;
import com.example.zoomcar.models.Booking;
import com.example.zoomcar.models.User;
import com.example.zoomcar.models.Vehicle;
import com.example.zoomcar.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Date;

@Controller
public class BookingController {
    private BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public BookingResponseDto bookVehicle(BookingRequestDto bookingRequestDto) {
        Booking booking = bookingService.bookVehicle(bookingRequestDto.getUser(),
                                                     bookingRequestDto.getVehicleId(),
                                                     bookingRequestDto.getStartDate(),
                                                     bookingRequestDto.getEndDate());

        BookingResponseDto bookingResponseDto = new BookingResponseDto();
        bookingResponseDto.setVehicle(booking.getVehicle());
        bookingResponseDto.setStartDate(booking.getStartDate());
        bookingResponseDto.setEndDate(booking.getEndDate());
        bookingResponseDto.setUser(booking.getRenter());
        return bookingResponseDto;
    }
}
