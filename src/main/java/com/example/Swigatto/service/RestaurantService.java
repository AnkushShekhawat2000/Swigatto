package com.example.Swigatto.service;

import com.example.Swigatto.dto.request.MenuRequest;
import com.example.Swigatto.dto.request.RestaurantRequest;
import com.example.Swigatto.dto.response.RestaurantResponse;
import com.example.Swigatto.exception.RestaurantNotFound;
import com.example.Swigatto.model.MenuItem;
import com.example.Swigatto.model.Restaurant;
import com.example.Swigatto.repository.RestaurantRepository;
import com.example.Swigatto.transformer.FoodItemTransformer;
import com.example.Swigatto.transformer.RestaurantTransformer;
import com.example.Swigatto.utils.ValidateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {


    final RestaurantRepository restaurantRepository;
    final ValidateUtils validateUtils;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository, ValidateUtils validateUtils) {
        this.restaurantRepository = restaurantRepository;
        this.validateUtils = validateUtils;
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


        if(!validateUtils.validateRestaurantId(id))
        {
            throw new RestaurantNotFound("Restaurant doesn't exist!!!");
        }

        Restaurant restaurant = restaurantRepository.findById(id).get();
        restaurant.setOpened(!restaurant.isOpened());
        restaurantRepository.save(restaurant);

        if(restaurant.isOpened())
        {
            return "Restaurant is opened now!!!";
        }

        return "Restaurant is closed";

    }

    public RestaurantResponse addMenuItemToRestaurant(MenuRequest menuRequest) {

        //check restaurant is valid or not

        if(!validateUtils.validateRestaurantId(menuRequest.getRestaurantId()))
        {
            throw new RestaurantNotFound("Restaurant doesn't exist!!!");
        }

        Restaurant restaurant = restaurantRepository.findById(menuRequest.getRestaurantId()).get();

        // make food entity
        MenuItem menuItem = FoodItemTransformer.FoodRequestToFoodItem((menuRequest));
        menuItem.setRestaurant(restaurant);

        restaurant.getAvailableMenuItems().add(menuItem);

        // save restaurant and food

        Restaurant savedRestaurant = restaurantRepository.save(restaurant);

        // preapare response

        return RestaurantTransformer.RestaurantToRestaurantResponse(savedRestaurant);


    }
}
