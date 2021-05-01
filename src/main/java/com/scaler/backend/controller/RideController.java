package com.scaler.backend.controller;

import com.scaler.backend.dto.DriverResponse;
import com.scaler.backend.dto.RideResponse;
import com.scaler.backend.exceptions.RideNotFoundException;
import com.scaler.backend.model.Driver;
import com.scaler.backend.services.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RideController {

    @Autowired
    private RideService rideService;

    @PostMapping("ride/:ride_id/accept-ride")
    public RideResponse acceptRide(@PathVariable Integer ride_id, @RequestParam String driver_id){
        RideResponse rideResponse = new RideResponse();
        try {
            rideResponse = rideService.acceptRideService(ride_id, driver_id);
        }
        catch (Throwable e){
            rideResponse.setMessage(e.getMessage());
            rideResponse.setSuccess(false);
            rideResponse.setRide(null);
        }
        return rideResponse;
    }
    @GetMapping("rides")
    public List<RideResponse> getAllRides(@RequestParam String driverId){
        return List.of(new RideResponse());
    }

}
