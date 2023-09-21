package com.example.Swigatto.transformer;

import com.example.Swigatto.dto.response.CartResponse;
import com.example.Swigatto.model.Cart;

import java.util.ArrayList;

public class CartTransformer {
    public static CartResponse CartToCartResponse(Cart cart)
    {
        return  CartResponse.builder()
                .cartTotal(cart.getCartTotal())
                .foodItems(new ArrayList<>())
                .build();


    }
}
