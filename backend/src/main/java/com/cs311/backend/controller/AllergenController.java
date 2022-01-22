package com.cs311.backend.controller;

import com.cs311.backend.entity.Allergen;
import com.cs311.backend.entity.Dish;
import com.cs311.backend.service.AllergenService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AllergenController {

    private AllergenService allergenService;

    public AllergenController(AllergenService allergenService){
        this.allergenService = allergenService;
    }

    @PostMapping("/allergen/findAllergensByDish")
    public List<Allergen> findAllergensByDish(@RequestBody Dish dish){
        return allergenService.findAllergensByDish(dish);
    }
}
