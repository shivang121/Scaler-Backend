package com.scaler.backend.dto;

import com.scaler.backend.model.Ride;
import lombok.Data;

@Data
public class RideResponse extends Response{
    private Ride ride;
}
