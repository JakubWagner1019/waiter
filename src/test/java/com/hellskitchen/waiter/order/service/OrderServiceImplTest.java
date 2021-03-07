package com.hellskitchen.waiter.order.service;

import com.hellskitchen.waiter.order.model.Order;
import com.hellskitchen.waiter.order.repository.LocalOrderRepository;
import com.hellskitchen.waiter.order.repository.MockOrderRepository;
import org.junit.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderServiceImplTest {

    @Test
    public void get() {
        OrderServiceImpl orderServiceImpl = new OrderServiceImpl(new MockOrderRepository());
        Optional<Order> optionalOrder = orderServiceImpl.get(0);
        assertTrue(optionalOrder.isPresent());
        Order order = optionalOrder.get();
        assertEquals(Order.OrderStatus.PENDING_APPROVAL, order.getStatus());
        assertEquals(2,order.getOrder().size());
        assertEquals(new Order.OrderEntry(3,2),order.getOrder().get(0));
        assertEquals(new Order.OrderEntry(2,1),order.getOrder().get(1));
    }

    @Test
    public void create() {
    }

    @Test
    public void remove() {
    }

    @Test
    public void acceptOrder() {
        OrderServiceImpl orderService = new OrderServiceImpl(new LocalOrderRepository());
        Order order = new Order();
        order.addOrderEntry(3,2);
        long id = orderService.create(order);
        orderService.acceptOrder(id);
        assertEquals(Order.OrderStatus.ACCEPTED, orderService.get(id).get().getStatus());
    }

    @Test
    public void declineOrder() {
    }

    @Test
    public void completeOrder() {
    }
}