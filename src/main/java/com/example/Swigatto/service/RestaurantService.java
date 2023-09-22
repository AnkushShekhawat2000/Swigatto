package com.example.Swigatto.service;

import com.example.Swigatto.dto.request.RestaurantRequest;
import com.example.Swigatto.dto.response.RestaurantResponse;
import com.example.Swigatto.exception.RestaurantNotFound;
import com.example.Swigatto.model.Restaurant;
import com.example.Swigatto.repository.RestaurantRepository;
import com.example.Swigatto.transformer.RestaurantTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RestaurantService {


    final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public RestaurantResponse addRestaurant(RestaurantRequest restaurantRequest) {
        //dto to model
        Restaurant restaurant = RestaurantTransformer.RestaurantRequestToRestaurant(restaurantRequest);

        // persist or save model in db
      Restaurant savedRestaurant =  restaurantRepository.save(restaurant);

      // prepare responsee dto from model
        return RestaurantTransformer.RestaurantToRestaurantResponse(savedRestaurant);


    }

    public String changeOpenedStatus(int id) {

        // check whether id is valid or not

        Optional<Restaurant>  restaurantOptional = restaurantRepository.findById(id);

        if(restaurantOptional.isEmpty())
        {
            throw new RestaurantNotFound("Restaurant doesn't exist!!!");
        }

        Restaurant restaurant = restaurantOptional.get();
        restaurant.setOpened(!restaurant.isOpened());
        restaurantRepository.save(restaurant);

        if(restaurant.isOpened())
        {
            return "Restaurant is opened now!!!";
        }

        return "Restaurant is closed";

    }
}
