package com.cs311.backend.controller;

import com.cs311.backend.entity.Dish;
import com.cs311.backend.service.RatingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class RatingController {

    private final RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    // get average rating for a dish
    @PostMapping("/rating/avg")
    public BigDecimal avgRating(@RequestBody Dish dish){
        return ratingService.avgRating(dish);
    }
}
