package com.cs311.backend.repository;

import com.cs311.backend.entity.Bar;
import com.cs311.backend.entity.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BarRepository extends JpaRepository<Bar, Integer> {


}
