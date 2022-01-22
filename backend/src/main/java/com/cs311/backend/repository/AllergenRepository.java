package com.cs311.backend.repository;

import com.cs311.backend.entity.Allergen;
import com.cs311.backend.entity.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AllergenRepository extends JpaRepository<Allergen, Integer> {

    List<Allergen> findAllByDish(Dish dish);
}
