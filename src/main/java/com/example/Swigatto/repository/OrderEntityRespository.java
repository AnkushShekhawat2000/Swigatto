package com.example.Swigatto.repository;

import com.example.Swigatto.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderEntityRespository extends JpaRepository<OrderEntity, Integer> {


}
