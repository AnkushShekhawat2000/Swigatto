package com.example.Swigatto.repository;

import com.example.Swigatto.model.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<MenuItem,Integer> {

}
