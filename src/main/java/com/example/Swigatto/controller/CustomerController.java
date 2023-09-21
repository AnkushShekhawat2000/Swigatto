package com.example.Swigatto.controller;

import com.example.Swigatto.dto.request.CustomerRequest;
import com.example.Swigatto.dto.response.CustomerResponse;
import com.example.Swigatto.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    /*
    constructor injection alays use in interprise application
     */
//   final CustomerService customerService;
//
//   @Autowired
//    public CustomerController(CustomerService customerService)
//    {
//        this.customerService = customerService;
//    }

    @PostMapping("/add")
    public ResponseEntity addCustomer(@RequestBody CustomerRequest customerRequest)
    {
         CustomerResponse customerResponse =  customerService.addCustomer(customerRequest);

         return new ResponseEntity(customerResponse, HttpStatus.CREATED);


    }

}
