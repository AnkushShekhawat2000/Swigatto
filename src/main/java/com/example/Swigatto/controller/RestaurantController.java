package com.example.Swigatto.controller;


import com.example.Swigatto.dto.request.MenuRequest;
import com.example.Swigatto.dto.request.RestaurantRequest;
import com.example.Swigatto.dto.response.RestaurantResponse;
import com.example.Swigatto.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    final RestaurantService restaurantService;





     /**
      * constructor Injection
      * @param restaurantService -->bean of restaurant Service
      */
    @Autowired
     public RestaurantController(RestaurantService restaurantService) {
          this.restaurantService = restaurantService;

    }


     @PostMapping("/add")
     public ResponseEntity addRestaurant(@RequestBody RestaurantRequest restaurantRequest)
     {
         RestaurantResponse restaurantResponse = restaurantService.addRestaurant(restaurantRequest);
         return new ResponseEntity(restaurantResponse, HttpStatus.CREATED);

     }


     @PutMapping("/update/status")
     public ResponseEntity changeOpenedStatus(int id)
     {
         String message = restaurantService.changeOpenedStatus(id);

         return new ResponseEntity(message, HttpStatus.ACCEPTED);
     }

     @PostMapping("/add/menu")
     public ResponseEntity addMenuItemToRestaurant(@RequestBody MenuRequest menuRequest)
     {
         RestaurantResponse restaurantResponse = restaurantService.addMenuItemToRestaurant(menuRequest);
         return new ResponseEntity(restaurantResponse,HttpStatus.CREATED);
     }

     // get menu of a restaurant



}
