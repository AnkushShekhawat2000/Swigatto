package com.example.Swigatto.dto.request;

import com.example.Swigatto.Enum.FoodCategory;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FoodRequest {

    int restaurantId;
    String dishName;

    double price;

    FoodCategory category;

    boolean veg;

    boolean available;




}
