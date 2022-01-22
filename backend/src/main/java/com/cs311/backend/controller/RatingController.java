package com.cs311.backend.controller;

import com.cs311.backend.entity.Dish;
import com.cs311.backend.entity.Rating;
import com.cs311.backend.service.RatingService;
import org.springframework.http.ResponseEntity;
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

    // create a new rating if the student hasn't rated the dish
    // update rating otherwise
    // TODO: handle check and update
    @PostMapping("/rating/newRating")
    public ResponseEntity<String> newRating(@RequestBody Rating rating){

        try {
            ratingService.newRating(rating);
            return ResponseEntity.ok("New rating saved!");
        } catch (Exception x) {
            return ResponseEntity.badRequest().body("Failed to save new rating!");
        }

    }
}
