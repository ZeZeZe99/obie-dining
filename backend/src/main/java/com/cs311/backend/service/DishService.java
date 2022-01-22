package com.cs311.backend.service;

import com.cs311.backend.entity.Dish;
import com.cs311.backend.repository.DishRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishService{

    private final DishRepository dishRepository;

    public DishService(DishRepository dishRepository){
        this.dishRepository = dishRepository;
    }

    public Dish create(Dish dish){
        return dishRepository.save(dish);
    }

    public List<Dish> findAllBySomething(String searchQuery, String sortBy)
    {   //boolean a;
//        if (sortBy.compareTo("1") > 0)
//        {a = false;}
        List<Dish> a = dishRepository.findDishesByNameLike(searchQuery);
        return a;}

//    public Dish getDishBy(Integer dishID){
//        return dishRepository.getDishById(dishID);
//    }


}
