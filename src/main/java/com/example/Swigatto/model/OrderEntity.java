package com.example.Swigatto.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.engine.internal.Cascade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="order_entity")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String orderId; // UUID

    int orderTotal;

    @CreationTimestamp
    Date orderTime;

    @ManyToOne
    @JoinColumn
    Customer customer;

    @ManyToOne
    @JoinColumn
    DeliveryPartner deliveryPartner;

   @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    List<FoodItem> foodItems  = new ArrayList<>();

   @ManyToOne
   @JoinColumn
   Restaurant restaurant;



}
