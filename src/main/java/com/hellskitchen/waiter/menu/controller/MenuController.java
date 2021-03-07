package com.hellskitchen.waiter.menu.controller;

import com.hellskitchen.waiter.menu.model.Menu;
import com.hellskitchen.waiter.menu.service.MenuService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/menu")
    public Menu getMenu(){
        return menuService.get();
    }
}
