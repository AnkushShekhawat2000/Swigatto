package com.example.Swigatto.service;

import com.example.Swigatto.dto.request.CustomerRequest;
import com.example.Swigatto.dto.response.CustomerResponse;
import com.example.Swigatto.exception.CustomerNotFoundException;
import com.example.Swigatto.model.Cart;
import com.example.Swigatto.model.Customer;
import com.example.Swigatto.repository.CustomerRepository;
import com.example.Swigatto.transformer.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {


    @Autowired
    CustomerRepository customerRepository;
    public CustomerResponse addCustomer(CustomerRequest customerRequest) {

        // dto to customer model
      Customer customer = CustomerTransformer.CustomerRequestToCustomer(customerRequest);

      // allocate a cart

        Cart cart = Cart.builder()
                .cartTotal(0)
                .customer(customer)
                .build();

        customer.setCart(cart);


        // save both customer and cart
      Customer savedCustomer = customerRepository.save(customer);  //save both customer and cart


        // prepare the response dto
    // need transformer to convert model to dto

        return CustomerTransformer.CustomerToCustomerResponse(savedCustomer);


    }

    public CustomerResponse findCustomerByMobile(String mobile) {


            Customer customer = customerRepository.findByMobileNo(mobile);
            if(customer == null)
            {
               throw new CustomerNotFoundException("Invalid mobile no!!!");
            }

            return CustomerTransformer.CustomerToCustomerResponse(customer);

    }
}
