package com.example.Swigatto.transformer;

import com.example.Swigatto.dto.request.MenuRequest;
import com.example.Swigatto.dto.response.MenuResponse;
import com.example.Swigatto.model.MenuItem;

public class FoodItemTransformer {

    public static MenuItem FoodRequestToFoodItem(MenuRequest menuRequest)
    {
         return MenuItem.builder()
                 .dishName(menuRequest.getDishName())
                 .price(menuRequest.getPrice())
                 .category(menuRequest.getCategory())
                 .available(menuRequest.isAvailable())
                 .build();

    }
    public static MenuResponse FoodItemToFoodResponse(MenuItem menuItem){
        return MenuResponse.builder()
                .dishName(menuItem.getDishName())
                .price(menuItem.getPrice())
                .veg(menuItem.isVeg())
                .category(menuItem.getCategory())
                .build();
    }




}
