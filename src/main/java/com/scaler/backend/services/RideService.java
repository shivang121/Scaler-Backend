package com.scaler.backend.services;

import com.scaler.backend.dto.RideResponse;
import com.scaler.backend.exceptions.DriverNotFoundException;
import com.scaler.backend.exceptions.RideAlreadyCompletedException;
import com.scaler.backend.exceptions.RideInProgessException;
import com.scaler.backend.exceptions.RideNotFoundException;
import com.scaler.backend.model.Driver;
import com.scaler.backend.model.Ride;
import com.scaler.backend.model.RideStatus;
import com.scaler.backend.repository.DriverRepository;
import com.scaler.backend.repository.RideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RideService {
    @Autowired
    private RideRepository rideRepository;


    @Autowired
    private DriverRepository driverRepository;

    public RideResponse acceptRideService(Integer id, String driver_id) throws NumberFormatException, RideNotFoundException, RideAlreadyCompletedException, RideInProgessException, DriverNotFoundException {
        Optional<Ride> ride = rideRepository.findById(id);
        if(ride.isEmpty()){
            throw new RideNotFoundException("The Requested Ride does not exist :(");
        }
        if(ride.get().getStatus().equals(RideStatus.COMPLETED)){
            throw new RideAlreadyCompletedException("The Requested Ride is already completed :(");
        }
        if(ride.get().getStatus().equals(RideStatus.ONGOING)){
            throw new RideInProgessException("The Requested Ride is in progress");
        }
        Integer driverId = Integer.parseInt(driver_id);
        Optional<Driver> driver = driverRepository.findById(driverId);
        if(driver.isEmpty()){
            throw new DriverNotFoundException("The Requested Driver does not exist :(");
        }

        ride.get().setDriver(driver.get());
        ride.get().setStatus(RideStatus.ONGOING);

        RideResponse rideResponse = new RideResponse();
        rideResponse.setSuccess(true);
        rideResponse.setMessage("Ride Accepted");
        rideResponse.setRide(ride.get());

        return rideResponse;
    }
}
