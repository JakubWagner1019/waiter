package com.hellskitchen.waiter.order.repository;

import com.hellskitchen.waiter.order.model.Order;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Profile("mock")
public class MockOrderRepository implements OrderRepository {

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

}
