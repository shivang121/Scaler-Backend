package com.scaler.backend.controller;

import com.scaler.backend.dto.DriverResponse;
import com.scaler.backend.model.Driver;
import com.scaler.backend.model.Person;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/drivers")
public class DriverController {
    @PostMapping("new")
    public DriverResponse addDriver(@RequestBody Person person){
        return new DriverResponse();
    }
}
