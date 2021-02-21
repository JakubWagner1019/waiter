package com.hellskitchen.waiter.order.service;

import com.hellskitchen.waiter.order.model.Order;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
@Profile("local")
public class LocalOrderService implements IOrderService {

    private final AtomicLong currentId = new AtomicLong(0);
    private final Map<Long, Order> orderStorage = new HashMap<>();

    @Override
    public Optional<Order> get(long id) {
        return Optional.ofNullable(orderStorage.get(id));
    }

    @Override
    public long create(Order order) {
        long id = currentId.incrementAndGet();
        orderStorage.put(id, order);
        return id;
    }

    @Override
    public boolean remove(long id) {
        if (orderStorage.containsKey(id)){
            orderStorage.remove(id);
            return true;
        }
        return false;
    }
}
