package com.example.Swigatto.repository;

import com.example.Swigatto.model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodItemRepository extends JpaRepository<FoodItem, Integer> {

}
