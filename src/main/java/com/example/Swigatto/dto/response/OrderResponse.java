package com.example.Swigatto.dto.response;

import com.example.Swigatto.model.FoodItem;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;


@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {

    String orderId; // UUID

    int orderTotal;


    Date orderTime;


    String customerName;

    String customerMobile;


    String deliveryPartner;

    String deliveryPartnerMobile;


    String restaurantName;



    List<FoodResponse> foodResponses;
}
