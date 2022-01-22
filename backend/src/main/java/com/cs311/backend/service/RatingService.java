package com.cs311.backend.service;

import com.cs311.backend.entity.Dish;
import com.cs311.backend.entity.Rating;
import com.cs311.backend.entity.Student;
import com.cs311.backend.repository.RatingRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    // create a new rating
    @Transactional
    public void newRating(Rating rating){
        Rating existedRating = ratingRepository.findByDishAndStudent(rating.getDish(),rating.getStudent());
        if (existedRating == null){
            ratingRepository.save(rating);
        } else {
            existedRating.setRating(rating.getRating());
            ratingRepository.save(existedRating);
        }

    }

}
