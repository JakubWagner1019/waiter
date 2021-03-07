package com.hellskitchen.waiter.order.service;

import com.hellskitchen.waiter.order.model.Order;
import com.hellskitchen.waiter.order.repository.OrderRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Profile("local")
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Optional<Order> get(long id) {
        return this.orderRepository.get(id);
    }

    @Override
    public long create(Order order) {
        return this.orderRepository.create(order);
    }

    @Override
    public boolean remove(long id) {
        return this.orderRepository.remove(id);
    }

    @Override
    public void acceptOrder(long id) {
        Optional<Order> order = this.orderRepository.get(id);
        order.orElseThrow(NoSuchElementException::new).setStatus(Order.OrderStatus.ACCEPTED);
    }

    @Override
    public void declineOrder(long id) {
        Optional<Order> order = this.orderRepository.get(id);
        order.orElseThrow(NoSuchElementException::new).setStatus(Order.OrderStatus.ACCEPTED);
    }

    @Override
    public void completeOrder(long id) {
        Optional<Order> order = this.orderRepository.get(id);
        order.orElseThrow(NoSuchElementException::new).setStatus(Order.OrderStatus.ACCEPTED);
    }
}
