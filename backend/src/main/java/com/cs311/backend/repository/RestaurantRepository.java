/* Repository class for restaurant
* The repository class allows communication with the database */
package com.cs311.backend.repository;

import com.cs311.backend.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // set this interface as a repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

    // JpaRepository has some built-in methods
    // declare other methods if needed

}
