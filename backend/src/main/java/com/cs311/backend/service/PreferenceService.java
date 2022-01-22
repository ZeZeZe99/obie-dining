package com.cs311.backend.service;

import com.cs311.backend.entity.Dish;
import com.cs311.backend.entity.Preference;
import com.cs311.backend.repository.PreferenceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreferenceService {
    private PreferenceRepository preferenceRepository;

    public PreferenceService(PreferenceRepository preferenceRepository){
        this.preferenceRepository = preferenceRepository;
    }

    public List<Preference> findPreferencesByDish(Dish dish){
        return preferenceRepository.findAllByDish(dish);
    }
}
