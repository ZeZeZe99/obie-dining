package com.cs311.backend.service;

import com.cs311.backend.entity.Restaurant;
import org.springframework.stereotype.Service;
import com.cs311.backend.repository.RestaurantRepository;

import java.util.List;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository){
        this.restaurantRepository = restaurantRepository;
    }

    public List<Restaurant> getAll(){
        return this.restaurantRepository.findAll();
    }
}
