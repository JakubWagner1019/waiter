package com.hellskitchen.waiter.order.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {

    enum OrderStatus{
        ACCEPTED,
        DECLINED,
        COMPLETED
    }

    private final List<OrderEntry> order = new ArrayList<>();

    public boolean addOrderEntry(long dishId, long count){
        return order.add(new OrderEntry(dishId, count));
    }

    public List<OrderEntry> getOrder() {
        return Collections.unmodifiableList(order);
    }

    @Override
    public String toString() {
        return "Order{" +
                "entryList=" + order +
                '}';
    }

    public static class OrderEntry {
        private long dishId;
        private long count;

        public OrderEntry(){
        }

        public OrderEntry(long dishId, long count) {
            this.dishId = dishId;
            this.count = count;
        }

        public long getDishId() {
            return dishId;
        }

        public long getCount() {
            return count;
        }


        public void setDishId(long dishId) {
            this.dishId = dishId;
        }

        public void setCount(long count) {
            this.count = count;
        }

        @Override
        public String toString() {
            return "OrderEntry{" +
                    "dishId=" + dishId +
                    ", count=" + count +
                    '}';
        }
    }
}
