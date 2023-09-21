package com.example.Swigatto.exception;

import com.example.Swigatto.dto.response.CustomerResponse;

public class CustomerNotFoundException extends RuntimeException{

    public CustomerNotFoundException(String message)
    {
        super(message);
    }
}
