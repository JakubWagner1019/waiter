package com.hellskitchen.waiter.order.repository;

import com.hellskitchen.waiter.order.model.Order;

import java.util.Optional;

public interface OrderRepository {
    Optional<Order> get(long id);
    long create(Order order);
    boolean remove(long id);
}
