package com.example.Swigatto.dto.request;


import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FoodRequest {

    int requiredQuantity;

    String customerMobile;

    int menuItemId;


}
