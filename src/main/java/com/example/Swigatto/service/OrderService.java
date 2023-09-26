package com.example.Swigatto.service;

import com.example.Swigatto.dto.response.OrderResponse;
import com.example.Swigatto.exception.CustomerNotFoundException;
import com.example.Swigatto.exception.EmptyCartException;
import com.example.Swigatto.model.*;
import com.example.Swigatto.repository.CustomerRepository;
import com.example.Swigatto.repository.DeliveryPartnerRepository;
import com.example.Swigatto.repository.OrderEntityRespository;
import com.example.Swigatto.repository.RestaurantRepository;
import com.example.Swigatto.transformer.OrderTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class OrderService {

    final CustomerRepository customerRepository;

    final DeliveryPartnerRepository deliveryPartnerRepository;

    final OrderEntityRespository orderEntityRespository;

    final RestaurantRepository restaurantRepository;

    @Autowired
    public OrderService(CustomerRepository customerRepository, DeliveryPartnerRepository deliveryPartnerRepository, OrderEntityRespository orderEntityRespository, RestaurantRepository restaurantRepository) {
        this.customerRepository = customerRepository;
        this.deliveryPartnerRepository = deliveryPartnerRepository;
        this.orderEntityRespository = orderEntityRespository;
        this.restaurantRepository = restaurantRepository;
    }




    public OrderResponse placeOrder(String customerMobile) {

        // verify the customer valid or not

        Customer customer = customerRepository.findByMobileNo(customerMobile);
        if(customer == null)
        {
            throw new CustomerNotFoundException("Invalid mobile number!!!");
        }

        // verify cart is empty or not
        Cart cart = customer.getCart();
        if(cart.getFoodItems().size() == 0)
        {
            throw new EmptyCartException("Sorry! Your cart is empty");
        }

        // fina a delivery partner to deliver order
        DeliveryPartner partner = deliveryPartnerRepository.findRandomDeliveryPartner();
        Restaurant restaurant = cart.getFoodItems().get(0).getMenuItem().getRestaurant();

        // prepare the order entity
        OrderEntity order = OrderTransformer.prepareOrderEntity(cart);

        OrderEntity savedOrder = orderEntityRespository.save(order);

        order.setCustomer(customer);
        order.setDeliveryPartner(partner);
        order.setRestaurant(restaurant);
        order.setFoodItems(cart.getFoodItems());

        customer.getOrders().add(savedOrder);
        partner.getOrders().add(savedOrder);
        restaurant.getOrders().add(savedOrder);

        for(FoodItem foodItem: cart.getFoodItems()){
            foodItem.setCart(null);
            foodItem.setOrder(savedOrder);
        }
        clearCart(cart);

        customerRepository.save(customer);
        deliveryPartnerRepository.save(partner);
        restaurantRepository.save(restaurant);

        // prepare orderresponse
        return OrderTransformer.OrderToOrderResponse(savedOrder);



    }

    private void clearCart(Cart cart) {
        cart.setCartTotal(0);
        cart.setFoodItems(new ArrayList<>());
    }
}
