package com.example.Swigatto.controller;

import com.example.Swigatto.dto.request.FoodRequest;
import com.example.Swigatto.dto.response.CartStatusResponse;
import com.example.Swigatto.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {

    final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    // add a foodItem to cart

    @PostMapping("/add")
    public ResponseEntity addFoodItemToCart(@RequestBody FoodRequest foodRequest)
    {
        try{

            CartStatusResponse cartStatusResponse = cartService.addFoodItemToCart(foodRequest);
           return new ResponseEntity(cartStatusResponse,HttpStatus.CREATED);
        }
        catch(Exception e)
        {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
}
