package com.example.Swigatto.transformer;


import com.example.Swigatto.dto.request.RestaurantRequest;
import com.example.Swigatto.dto.response.MenuResponse;
import com.example.Swigatto.dto.response.RestaurantResponse;

import com.example.Swigatto.model.Restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class RestaurantTransformer {

    public  static Restaurant RestaurantRequestToRestaurant(RestaurantRequest restaurantRequest)
    {
        return Restaurant.builder()
                .name(restaurantRequest.getName())
                .contactNumber(restaurantRequest.getContactNumber())
                .location(restaurantRequest.getLocation())
                .restaurantCategory(restaurantRequest.getRestaurantCategory())
                .opened(true)
                .availableMenuItems(new ArrayList<>())
                .orders(new ArrayList<>())
                .build();

    }

    public static RestaurantResponse RestaurantToRestaurantResponse(Restaurant restaurant){

        List<MenuResponse> menu = restaurant.getAvailableMenuItems()
                .stream()
                .map(foodItem -> FoodItemTransformer.FoodItemToFoodResponse(foodItem))
                .collect(Collectors.toList());

              return RestaurantResponse.builder()
                      .name(restaurant.getName())
                      .contactNumber(restaurant.getContactNumber())
                      .location(restaurant.getLocation())
                      .opened(restaurant.isOpened())
                      .menu(menu)
                      .build();
    }

}
