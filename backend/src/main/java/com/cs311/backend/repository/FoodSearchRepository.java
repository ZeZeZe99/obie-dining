package com.cs311.backend.repository;

import org.springframework.stereotype.Repository;
import com.cs311.backend.entity.Rating;
import com.cs311.backend.entity.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface FoodSearchRepository {
}
