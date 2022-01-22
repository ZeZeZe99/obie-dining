package com.cs311.backend.controller;

import com.cs311.backend.entity.Dish;
import com.cs311.backend.entity.Menu;
import com.cs311.backend.entity.Rating;
import com.cs311.backend.service.FoodSearchService;
import com.cs311.backend.service.DishService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FoodSearchController {

    private final DishService dishService;

    public FoodSearchController(DishService dishService){
        this.dishService = dishService;
    }


    @PostMapping("/foodSearch/findDishesIDByRating")
    public List<Dish> findDishesIDByRating(@RequestParam String searchQuery, @RequestParam String sortBy){
        return dishService.findAllBySomething(searchQuery, sortBy);
    }
}
