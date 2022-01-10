package com.cs311.backend.controller;

import com.cs311.backend.entity.Restaurant;
import com.cs311.backend.service.RestaurantService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping("/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService){
        this.restaurantService = restaurantService;
    }

    @GetMapping("/restaurants/get")
    public List<Restaurant> getAll(){
        System.out.println("hii");
        return this.restaurantService.getAll();
    }
}
