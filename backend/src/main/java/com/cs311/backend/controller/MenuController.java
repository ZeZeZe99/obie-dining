package com.cs311.backend.controller;

import com.cs311.backend.entity.Dish;
import com.cs311.backend.entity.Menu;
import com.cs311.backend.service.MenuService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MenuController {

    private MenuService menuService;

    public MenuController(MenuService menuService){
        this.menuService = menuService;
    }

    // find dishes by bar and date and slot
    @PostMapping("/menu/findDishesByBarAndDateAndSlot")
    public List<Dish> findDishesByBarAndDateAndSlot(@RequestBody Menu menu){
        return menuService.findDishesByBarAndDateAndSlot(menu);
    }
}
