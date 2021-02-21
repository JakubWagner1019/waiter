package com.hellskitchen.waiter.order.controller;

import com.hellskitchen.waiter.order.model.Order;
import com.hellskitchen.waiter.order.service.IOrderService;
import com.hellskitchen.waiter.order.util.IOrderReader;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Optional;

@RestController
public class OrderController {

    private final IOrderService orderService;
    private final IOrderReader orderReader;

    public OrderController(IOrderService orderService, IOrderReader orderReader) {
        this.orderService = orderService;
        this.orderReader = orderReader;
    }

    @GetMapping("/order/{id}")
    public String doGet(@PathVariable long id){
        Optional<Order> order = orderService.get(id);
        if (order.isPresent()){
            return order.get().toString();
        }
        return "Not Found";
    }

    @PostMapping("/order")
    public String doPost(@RequestBody String orderAsJson){
        Order order = orderReader.read(orderAsJson);
        long newId = orderService.create(order);
        return String.valueOf(newId);
    }

    @PutMapping("/order")
    public String doPut(){
        throw new NotImplementedException();
    }

    @DeleteMapping("/order/{id}")
    public String doDelete(@PathVariable int id){
        boolean status = orderService.remove(id);
        return String.valueOf(status);
    }

}
