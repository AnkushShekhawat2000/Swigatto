package com.example.Swigatto.utils;

import com.example.Swigatto.model.Restaurant;
import com.example.Swigatto.repository.RestaurantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ValidateUtils {

    final RestaurantRepository restaurantRepository;


    @Autowired
    public ValidateUtils(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public  boolean validateRestaurantId(int id)
    {
        Optional<Restaurant>  restaurantOptional = restaurantRepository.findById(id);

            return restaurantOptional.isPresent();

    }
}
