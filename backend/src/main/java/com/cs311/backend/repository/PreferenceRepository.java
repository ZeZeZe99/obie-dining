package com.cs311.backend.repository;

import com.cs311.backend.entity.Dish;
import com.cs311.backend.entity.Preference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PreferenceRepository extends JpaRepository<Preference, Integer> {

    public List<Preference> findAllByDish(Dish dish);
}
