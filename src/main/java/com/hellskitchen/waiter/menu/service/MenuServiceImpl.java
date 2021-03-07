package com.hellskitchen.waiter.menu.service;

import com.hellskitchen.waiter.menu.model.Menu;
import com.hellskitchen.waiter.menu.repository.MenuRepository;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;

    public MenuServiceImpl(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Override
    public Menu get() {
        return menuRepository.get();
    }
}
