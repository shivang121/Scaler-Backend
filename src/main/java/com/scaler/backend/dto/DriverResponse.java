package com.scaler.backend.dto;

import com.scaler.backend.model.Driver;
import lombok.Data;

@Data
public class DriverResponse extends Response {
    public Driver driver;
}
