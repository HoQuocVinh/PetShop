package com.stc.petlove.service;

import com.stc.petlove.entities.Order;
import com.stc.petlove.payload.PageResponse;

public interface OrderService {
    PageResponse getAllOrder(int pageNo, int pageSize, String sortBy, String sortDir);
    Order getOrderById(String id);
    Order saveOrder(Order order);
    Order updateOrder(String id, Order order);
    boolean deleteOrder(String id);
}
