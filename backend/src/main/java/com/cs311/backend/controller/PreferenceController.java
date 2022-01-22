package com.cs311.backend.controller;

import com.cs311.backend.entity.Dish;
import com.cs311.backend.entity.Preference;
import com.cs311.backend.service.PreferenceService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PreferenceController {

    private PreferenceService preferenceService;

    public PreferenceController(PreferenceService preferenceService){
        this.preferenceService = preferenceService;
    }

    @PostMapping("/preference/findPreferencesByDish")
    public List<Preference> findPreferencesByDish(@RequestBody Dish dish){
        return preferenceService.findPreferencesByDish(dish);
    }
}
