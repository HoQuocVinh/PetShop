package com.hcmute.vinh19110318.service;

import com.hcmute.vinh19110318.entities.Order;
import com.hcmute.vinh19110318.payload.PageResponse;

public interface OrderService {
    PageResponse getAllOrder(int pageNo, int pageSize, String sortBy, String sortDir);
    Order getOrderById(String id);
    Order saveOrder(Order order);
    Order updateOrder(String id, Order order);
    boolean deleteOrder(String id);
}
