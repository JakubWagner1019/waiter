package com.hellskitchen.waiter.order.service;

import com.hellskitchen.waiter.order.model.Order;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Profile("notused")
public class MockOrderService implements OrderService {

    @Override
    public Optional<Order> get(long id) {
        Order order = new Order();
        order.addOrderEntry(3,2);
        order.addOrderEntry(2,1);
        return Optional.of(order);
    }

    @Override
    public long create(Order order) {
        return 0;
    }

    @Override
    public boolean remove(long id) {
        return false;
    }

    @Override
    public void acceptOrder(long id) {
    }

    @Override
    public void declineOrder(long id) {
    }

    @Override
    public void completeOrder(long id) {
    }
}
