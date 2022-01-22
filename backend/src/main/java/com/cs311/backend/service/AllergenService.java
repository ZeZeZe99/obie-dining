package com.cs311.backend.service;

import com.cs311.backend.entity.Allergen;
import com.cs311.backend.entity.Dish;
import com.cs311.backend.repository.AllergenRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllergenService {

    private AllergenRepository allergenRepository;

    public AllergenService(AllergenRepository allergenRepository){
        this.allergenRepository = allergenRepository;
    }

    public List<Allergen> findAllergensByDish(Dish dish){
        return allergenRepository.findAllByDish(dish);
    }
}
