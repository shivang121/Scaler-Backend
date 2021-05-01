package com.scaler.backend.dto;

import lombok.Data;

@Data
public abstract class Response {
    private boolean success;
    private String message;
}
