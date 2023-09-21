package com.example.Swigatto.transformer;

import com.example.Swigatto.dto.request.CustomerRequest;
import com.example.Swigatto.dto.response.CartResponse;
import com.example.Swigatto.dto.response.CustomerResponse;
import com.example.Swigatto.model.Customer;

public class CustomerTransformer {

    public static Customer CustomerRequestToCustomer(CustomerRequest customerRequest)
    {
        return Customer.builder()
                .name(customerRequest.getName())
                .email(customerRequest.getEmail())
                .address(customerRequest.getAddress())
                .mobileNo(customerRequest.getMobileNo())
                .gender(customerRequest.getGender())
                .build();

    }

    public static  CustomerResponse CustomerToCustomerResponse(Customer customer){

        CartResponse cartResponse = CartTransformer.CartToCartResponse(customer.getCart());
        return CustomerResponse.builder()
                .name(customer.getName())
                .mobileNo(customer.getMobileNo())
                .address(customer.getAddress())
                .cart(cartResponse)
                .build();
    }
}
