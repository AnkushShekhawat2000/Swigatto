package com.example.Swigatto.dto.response;

import com.example.Swigatto.Enum.FoodCategory;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodResponse {
    String dishName;

    double price;

    FoodCategory category;

    boolean veg;


}
