/* Service class for restaurant
* The service class are called by the controller, deals with the business logic, then passes to the repository interface*/

package com.cs311.backend.service;

import com.cs311.backend.entity.Restaurant;
import org.springframework.stereotype.Service;
import com.cs311.backend.repository.RestaurantRepository;

import java.util.List;

@Service // set this class as a service class
public class RestaurantService {

    // use its repository
    private final RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository){
        this.restaurantRepository = restaurantRepository;
    }

    // methods that deal with the business logic, then pass to the repository
    public List<Restaurant> getAll(){
//        List<Restaurant> restaurantList = this.restaurantRepository.findAll();
        return this.restaurantRepository.findAll();
    }
}
