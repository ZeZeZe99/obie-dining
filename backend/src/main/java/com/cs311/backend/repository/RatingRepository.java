package com.cs311.backend.repository;

import com.cs311.backend.entity.Dish;
import com.cs311.backend.entity.Rating;
import com.cs311.backend.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {

    @Query(value = "SELECT avg(rating) FROM Rating WHERE dish = ?1")
    public BigDecimal avgRating(Dish dish);

    public Rating findByDishAndStudent(Dish dish, Student student);

}
