package com.hellskitchen.waiter.order.util;

import com.hellskitchen.waiter.order.model.Order;

public interface OrderReader {
    Order read(String orderAsJson);
}
