package com.cs311.backend.repository;

import com.cs311.backend.entity.Bar;
import com.cs311.backend.entity.Dish;
import com.cs311.backend.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Integer> {


    List<Menu> findAllByBarAndDateAndSlot(Bar bar, Date date, String slot);

    List<Menu> findAllBySlot(String slot);



}
