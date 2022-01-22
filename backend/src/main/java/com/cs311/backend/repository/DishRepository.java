package com.cs311.backend.repository;

import com.cs311.backend.entity.Dish;
import com.cs311.backend.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DishRepository extends JpaRepository<Dish, Integer> {

    List<Dish> findAllByNameLike(String searchQuery);
}
