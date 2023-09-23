package com.example.Swigatto.exception;

public class MenuItemNotFound extends RuntimeException {

    public MenuItemNotFound(String message)
    {
        super(message);
    }
}
