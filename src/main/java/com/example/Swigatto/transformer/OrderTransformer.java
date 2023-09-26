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

    public static OrderEntity prepareOrderEntity(Cart cart)
    {

        return OrderEntity.builder()
                .orderId(String.valueOf(UUID.randomUUID()))
                .orderTotal(cart.getCartTotal())
                .build();
    }

    public static OrderResponse OrderToOrderResponse(OrderEntity saveOrder) {

        List<FoodResponse> foodResponseList = new ArrayList<>();
        for(FoodItem food: saveOrder.getFoodItems()) {


            FoodResponse foodResponse = FoodResponse.builder()
                    .dishName(food.getMenuItem().getDishName())
                    .price(food.getMenuItem().getPrice())
                    .category(food.getMenuItem().getCategory())
                    .veg(food.getMenuItem().isVeg())
                    .quantityAdded(food.getRequiredQuantity())
                    .build();
        }

        return OrderResponse.builder()
                .orderId(saveOrder.getOrderId())
                .orderTime(saveOrder.getOrderTime())
                .orderTotal(saveOrder.getOrderTotal())
                .customerName(saveOrder.getCustomer().getName())
                .customerMobile(saveOrder.getCustomer().getMobileNo())
                .deliveryPartner(saveOrder.getDeliveryPartner().getName())
                .deliveryPartnerMobile(saveOrder.getDeliveryPartner().getMobileNo())
                .restaurantName(saveOrder.getRestaurant().getName())
                .foodResponses(foodResponseList)
                .build();
    }
}
