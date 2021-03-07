package com.hellskitchen.waiter.order.util;

import com.hellskitchen.waiter.order.model.Order;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("mock")
public class MockOrderReader implements OrderReader {

    @Override
    public Order read(String orderAsJson) {
        return new Order();
    }
}
