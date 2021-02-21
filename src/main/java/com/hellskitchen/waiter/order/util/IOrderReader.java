package com.hellskitchen.waiter.order.util;

import com.hellskitchen.waiter.order.model.Order;

public interface IOrderReader {
    Order read(String orderAsJson);
}
