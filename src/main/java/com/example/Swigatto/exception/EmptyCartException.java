package com.example.Swigatto.exception;



public class EmptyCartException extends RuntimeException{

    public EmptyCartException(String message){
        super(message);
    }
}
