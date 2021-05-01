package com.scaler.backend.controller;

import com.scaler.backend.dto.DriverResponse;
import com.scaler.backend.dto.RideResponse;
import com.scaler.backend.exceptions.PersonDoesNotContainValidNameException;
import com.scaler.backend.exceptions.PersonDoesNotContainValidPhoneNumberException;
import com.scaler.backend.model.Driver;
import com.scaler.backend.model.Person;
import com.scaler.backend.services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/drivers")
public class DriverController {
    @Autowired
    DriverService driverService;

    @PostMapping("new")
    public DriverResponse addDriver(@RequestBody Person person){
        DriverResponse driverResponse = new DriverResponse();
        try {
            driverResponse = driverService.addDriverService(person);
        }
        catch (Throwable e){
            driverResponse.setMessage(e.getMessage());
            driverResponse.setSuccess(false);
            driverResponse.setDriver(null);
        }
        return driverResponse;
    }
}
