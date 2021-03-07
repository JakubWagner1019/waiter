package com.hellskitchen.waiter.menu.repository;

import com.hellskitchen.waiter.menu.model.Menu;
import org.springframework.stereotype.Repository;

@Repository
public class MockMenuRepository implements MenuRepository {

    @Override
    public Menu get() {
        Menu menu = new Menu();
        menu.addPosition(1,"Frytki");
        menu.addPosition(2,"Jajecznica");
        return menu;
    }

}
