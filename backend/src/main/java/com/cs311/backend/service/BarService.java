package com.cs311.backend.service;

import com.cs311.backend.entity.Dish;
import com.cs311.backend.repository.BarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarService {

    private BarRepository barRepository;

    public BarService(BarRepository barRepository){
        this.barRepository = barRepository;
    }


}
