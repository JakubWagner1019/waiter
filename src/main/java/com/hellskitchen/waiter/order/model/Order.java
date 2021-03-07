package com.hellskitchen.waiter.order.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Order {

    public enum OrderStatus{
        PENDING_APPROVAL,
        ACCEPTED,
        DECLINED,
        COMPLETED
    }

    public Order(){
        this.status = OrderStatus.PENDING_APPROVAL;
    }

    private OrderStatus status;
    private final List<OrderEntry> order = new ArrayList<>();

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public boolean addOrderEntry(long dishId, long count){
        return order.add(new OrderEntry(dishId, count));
    }

    public List<OrderEntry> getOrder() {
        return Collections.unmodifiableList(order);
    }

    @Override
    public String toString() {
        return "Order{" +
                "status=" + status +
                ", order=" + order +
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
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            OrderEntry that = (OrderEntry) o;
            return dishId == that.dishId && count == that.count;
        }

        @Override
        public int hashCode() {
            return Objects.hash(dishId, count);
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
