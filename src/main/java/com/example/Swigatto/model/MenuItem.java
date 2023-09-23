package com.example.Swigatto.model;

import com.example.Swigatto.Enum.FoodCategory;
import com.example.Swigatto.Enum.RestaurantCategory;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Menu")
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String dishName;

    double price;


    @Enumerated(EnumType.STRING)
    FoodCategory category;

    boolean veg;

    boolean available;



    @ManyToOne
    @JoinColumn
    Restaurant restaurant;

    @OneToMany(mappedBy = "menuItem", cascade = CascadeType.ALL)
    List<FoodItem> foodItems =  new ArrayList<>();


}
