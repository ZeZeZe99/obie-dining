/* Controller class for restaurant
* The controller class listens to http requests sent from the frontend, then passes to its service class
* It would also return the result to the frontend */

package com.cs311.backend.controller;

import com.cs311.backend.entity.Restaurant;
import com.cs311.backend.service.RestaurantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // set this class as a controller class
public class RestaurantController {

    // use its service class
    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService){
        this.restaurantService = restaurantService;
    }

    // methods that respond to the frontend
    // run this method when the frontend sends a http request to this path
    @GetMapping("/restaurants/get") // when the request uses a get method
    public List<Restaurant> getAll(){
        // pass to the service class
        return this.restaurantService.getAll();
    }
}
