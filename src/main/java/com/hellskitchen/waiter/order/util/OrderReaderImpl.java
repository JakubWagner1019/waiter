package com.hellskitchen.waiter.order.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hellskitchen.waiter.order.model.Order;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("local")
public class OrderReaderImpl implements IOrderReader {

    @Override
    public Order read(String orderAsJson) {
        ObjectMapper mapper = new ObjectMapper();
        Order order = null;
        try {
            order = mapper.readValue(orderAsJson, Order.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(order);
        return order;
    }
}
