package com.example.zoomcar.services;

import com.example.zoomcar.Exceptions.VehicleNotFoundExceptoin;
import com.example.zoomcar.models.Booking;
import com.example.zoomcar.models.User;
import com.example.zoomcar.models.Vehicle;
import com.example.zoomcar.repositories.BookingRepository;
import com.example.zoomcar.repositories.VehicleRepository;
import org.hibernate.annotations.AttributeAccessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class BookingService {
    private VehicleRepository vehicleRepository;
    private VehicleService vehicleService;
    private BookingRepository bookingRepository;

    @Autowired
    public BookingService(VehicleRepository vehicleRepository,VehicleService vehicleService, BookingRepository bookingRepository){
        this.vehicleRepository = vehicleRepository;
        this.vehicleService = vehicleService;
        this.bookingRepository = bookingRepository;
    }

    public Booking bookVehicle(User user, Long vehicleId, Date startDate, Date endDate) throws VehicleNotFoundExceptoin {
    /* *********ACQUIRE A LOCK HERE******************/
        Optional<Vehicle> optionalVehicle = vehicleRepository.findById(vehicleId);
        if(optionalVehicle.isPresent()) {
            Vehicle vehicle = optionalVehicle.get();
            if(!vehicleService.isVehicleAvailable(vehicle, startDate, endDate)) {
                // Release the lock and throw an exception
                throw new VehicleNotFoundExceptoin("Vehicle not available in this window, Already Booked");
            }

            Booking booking = new Booking();
            booking.setRenter(user);
            booking.setVehicle(vehicle);
            booking.setStartDate(startDate);
            booking.setEndDate(endDate);
            bookingRepository.save(booking);
            // Release the lock and return the booking
            return booking;
        }
        else { // Release the lock and throw an exception
            throw new VehicleNotFoundExceptoin("Vehicle not found");
        }
    }
}
