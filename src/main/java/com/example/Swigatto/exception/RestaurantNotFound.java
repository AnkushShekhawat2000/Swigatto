package com.example.Swigatto.exception;

public class RestaurantNotFound extends RuntimeException{

    public RestaurantNotFound(String message)
    {
        super(message);
    }
}
