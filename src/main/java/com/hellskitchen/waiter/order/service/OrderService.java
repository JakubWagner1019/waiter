package com.hellskitchen.waiter.order.service;

import com.hellskitchen.waiter.order.model.Order;

import java.util.Optional;

public interface OrderService {
    Optional<Order> get(long id);
    long create(Order order);
    boolean remove(long id);
    void acceptOrder(long id);
    void declineOrder(long id);
    void completeOrder(long id);
}
