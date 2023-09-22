package com.example.Swigatto.dto.request;

import com.example.Swigatto.Enum.RestaurantCategory;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantRequest {

    String name;

    String location;


    RestaurantCategory restaurantCategory;


    String contactNumber;
}
