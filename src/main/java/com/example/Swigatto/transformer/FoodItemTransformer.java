package com.example.Swigatto.transformer;

import com.example.Swigatto.dto.response.FoodResponse;
import com.example.Swigatto.model.FoodItem;

public class FoodItemTransformer {

    public static FoodResponse FoodItemToFoodResponse(FoodItem foodItem)
    {
         return FoodResponse.builder()
                 .dishName(foodItem.getDishName())
                 .price(foodItem.getPrice())
                 .veg(foodItem.isVeg())
                 .category(foodItem.getFoodCategory())
                 .build();
    }




}
