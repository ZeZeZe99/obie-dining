package com.cs311.backend.service;

import com.cs311.backend.entity.Bar;
import com.cs311.backend.entity.Dish;
import com.cs311.backend.entity.Menu;
import com.cs311.backend.repository.DishRepository;
import com.cs311.backend.repository.MenuRepository;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class MenuService {

    private final MenuRepository menuRepository;

    private final DishRepository dishRepository;

    public MenuService(MenuRepository menuRepository, DishRepository dishRepository) {
        this.menuRepository = menuRepository;
        this.dishRepository = dishRepository;
    }


    // find dishes by bar and date and slot
    public List<Dish> findDishesByBarAndDateAndSlot(Menu menu){
        // the frontend passes in the local date, but java would treat it as UTC and convert it to locate datetime
        // we need to correct this back
        Calendar calendar = Calendar.getInstance();
        int millisecond = calendar.get(Calendar.ZONE_OFFSET) + calendar.get(Calendar.DST_OFFSET);
        calendar.setTime(menu.getDate());
        calendar.add(Calendar.MILLISECOND, -millisecond);
        Date date = calendar.getTime();

        List<Menu> menus = menuRepository.findAllByBarAndDateAndSlot(menu.getBar(), date, menu.getSlot());
        List<Dish> dishes = new ArrayList<>();
        for (Menu m : menus){
            Dish dish = m.getDish();
            if (!dishes.contains(dish)){
                dishes.add(dish);
            }
        }
        return dishes;
    }





}
