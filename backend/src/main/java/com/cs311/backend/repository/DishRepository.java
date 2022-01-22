package com.cs311.backend.repository;

import com.cs311.backend.entity.Dish;
import com.cs311.backend.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface DishRepository extends JpaRepository<Dish, Integer> {
    @Query("SELECT d FROM Dish d WHERE d.name like %?1%")
    List<Dish> findDishesByNameLike(String searchQuery);

 //   List<Dish> findDishesByNameLike(String searchQuery);
}
