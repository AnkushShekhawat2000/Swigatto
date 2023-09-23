package com.example.Swigatto.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="food_item")
public class FoodItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    int requiredQuantity;

    double totalCost;


    @ManyToOne
    @JoinColumn
    Cart cart;

   @ManyToOne
   @JoinColumn
   MenuItem menuItem;

  @ManyToOne
  @JoinColumn
    OrderEntity order;

}
