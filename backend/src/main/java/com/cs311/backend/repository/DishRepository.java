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
    @Query("SELECT d FROM Dish d WHERE d.name LIKE %?1% ORDER BY d.name ASC")
    List<Dish> findDishesByNameLike(String searchQuery);

    @Query("SELECT d FROM Dish d WHERE d.name LIKE %?1% ORDER BY d.price ASC")
    List<Dish> findDishesByNameLikeSortByPrice(String searchQuery);

    @Query("SELECT d FROM Dish d WHERE d.name LIKE %?1% ORDER BY d.calories ASC")
    List<Dish> findDishesByNameLikeSortByCalories(String searchQuery);

    @Query("SELECT d FROM Dish d WHERE d.name LIKE %?1% ORDER BY d.name DESC")
    List<Dish> findDishesByNameLikeDec(String searchQuery);

    @Query("SELECT d FROM Dish d WHERE d.name LIKE %?1% ORDER BY d.price DESC")
    List<Dish> findDishesByNameLikeSortByPriceDec(String searchQuery);

    @Query("SELECT d FROM Dish d WHERE d.name LIKE %?1% ORDER BY d.calories DESC")
    List<Dish> findDishesByNameLikeSortByCaloriesDec(String searchQuery);
}
