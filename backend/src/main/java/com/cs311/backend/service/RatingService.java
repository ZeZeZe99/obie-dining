package com.cs311.backend.service;

import com.cs311.backend.entity.Dish;
import com.cs311.backend.repository.RatingRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class RatingService {

    private final RatingRepository ratingRepository;

    public RatingService (RatingRepository ratingRepository){
        this.ratingRepository = ratingRepository;
    }

    // get average rating for a dish
    public BigDecimal avgRating(Dish dish){
        return ratingRepository.avgRating(dish);
    }


}
