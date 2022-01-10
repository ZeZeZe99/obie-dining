package com.cs311.backend.repository;

import com.cs311.backend.entity.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DishRepository extends JpaRepository<Dish, Integer> {

    List<Dish> getDishesByBarId(Integer barId);

    Dish getDishById(Integer dishId);
}
