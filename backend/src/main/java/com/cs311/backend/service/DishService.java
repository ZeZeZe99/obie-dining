package com.cs311.backend.service;

import com.cs311.backend.entity.Dish;
import com.cs311.backend.repository.DishRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class DishService{

    private final DishRepository dishRepository;

    public DishService(DishRepository dishRepository){
        this.dishRepository = dishRepository;
    }

    public Dish create(Dish dish){
        return dishRepository.save(dish);
    }

    public List<Dish> findAllBySomething(String searchQuery, String sortBy, String sequence)
    {
        List<Dish> a;
        if((sortBy).toLowerCase().compareTo("name") == 0){
            if ((sequence).toLowerCase().compareTo("asc") == 0) {
                a = dishRepository.findDishesByNameLike(searchQuery);
            } else {
                a = dishRepository.findDishesByNameLikeDec(searchQuery);
            }
        } else if (sortBy.toLowerCase().compareTo("price") == 0){
            if ((sequence).toLowerCase().compareTo("asc") == 0) {
                a = dishRepository.findDishesByNameLikeSortByPrice(searchQuery);
            } else {
                a = dishRepository.findDishesByNameLikeSortByPriceDec(searchQuery);
            }
        } else {if ((sequence).toLowerCase().compareTo("asc") == 0) {
                a = dishRepository.findDishesByNameLikeSortByCalories(searchQuery);
            } else {
                a = dishRepository.findDishesByNameLikeSortByCaloriesDec(searchQuery);
            }
        }
        return a;
    }

//    public Dish getDishBy(Integer dishID){
//        return dishRepository.getDishById(dishID);
//    }


}
