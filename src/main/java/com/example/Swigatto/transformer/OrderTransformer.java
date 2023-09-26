package com.example.Swigatto.transformer;

import com.example.Swigatto.dto.response.FoodResponse;
import com.example.Swigatto.dto.response.OrderResponse;
import com.example.Swigatto.model.Cart;
import com.example.Swigatto.model.FoodItem;
import com.example.Swigatto.model.OrderEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderTransformer {

    public static OrderEntity prepareOrderEntity(Cart cart){
        return OrderEntity.builder()
                .orderId(String.valueOf(UUID.randomUUID()))
                .orderTotal(cart.getCartTotal())
                .build();
    }
    public static OrderResponse OrderToOrderResponse(OrderEntity savedOrder) {

        List<FoodResponse> foodResponseList = new ArrayList<>();
        for(FoodItem food: savedOrder.getFoodItems()){
            FoodResponse foodResponse = FoodResponse.builder()
                    .dishName(food.getMenuItem().getDishName())
                    .price(food.getMenuItem().getPrice())
                    .category(food.getMenuItem().getCategory())
                    .veg(food.getMenuItem().isVeg())
                    .quantityAdded(food.getRequiredQuantity())
                    .build();

            foodResponseList.add(foodResponse);
        }


        return OrderResponse.builder()
                .orderId(savedOrder.getOrderId())
                .orderTime(savedOrder.getOrderTime())
                .orderTotal(savedOrder.getOrderTotal())
                .customerName(savedOrder.getCustomer().getName())
                .customerMobile(savedOrder.getCustomer().getMobileNo())
                .deliveryPartner(savedOrder.getDeliveryPartner().getName())
                .deliveryPartnerMobile(savedOrder.getDeliveryPartner().getMobileNo())
                .restaurantName(savedOrder.getRestaurant().getName())
                .foodResponses(foodResponseList)
                .build();
    }
}
