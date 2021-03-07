package com.hellskitchen.waiter.menu.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Menu {

    private final List<MenuEntry> entries = new ArrayList<>();

    public void addPosition(int id, String name) {
        entries.add(new MenuEntry(id,name));
    }

    public List<MenuEntry> getEntries() {
        return Collections.unmodifiableList(entries);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return entries.equals(menu.entries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(entries);
    }

    @Override
    public String toString() {
        return "Menu{" +
                "entries=" + entries +
                '}';
    }

    private static class MenuEntry{

        private final long id;
        private final String name;

        private MenuEntry(long id, String name) {
            this.id = id;
            this.name = name;
        }

        public long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MenuEntry menuEntry = (MenuEntry) o;
            return id == menuEntry.id && Objects.equals(name, menuEntry.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }

        @Override
        public String toString() {
            return "MenuEntry{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
