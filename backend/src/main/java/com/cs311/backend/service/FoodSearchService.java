package com.cs311.backend.service;
import com.cs311.backend.entity.Dish;
import com.cs311.backend.entity.Menu;
import com.cs311.backend.entity.Rating;
import com.cs311.backend.repository.DishRepository;
import com.cs311.backend.repository.RatingRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodSearchService {
//    private final DishRepository dishRepository;
//    private final RatingRepository ratingRepository;
//
//    public FoodSearchService(DishRepository dishRepository, RatingRepository ratingRepository) {
//        this.dishRepository = dishRepository;
//        this.ratingRepository = ratingRepository;
//    }
//    public List<Dish> findDishesBySortMethod(Rating rating){
//        List<Dish> dishes = DishRepository.findDishesIDByRating(rating.getDish().getName(), ".");
//
//        return dishes;
//    }
}
