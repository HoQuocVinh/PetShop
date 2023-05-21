package com.stc.petlove.service.impl;

import com.stc.petlove.entities.Order;
import com.stc.petlove.entities.Role;
import com.stc.petlove.exception.NotFoundException;
import com.stc.petlove.payload.PageResponse;
import com.stc.petlove.repository.OrderRepository;
import com.stc.petlove.service.OrderService;
import com.stc.petlove.service.SetPageResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final SetPageResponse<Order> setPageResponse;

    @Override
    public PageResponse getAllOrder(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        Page<Order> orders  = orderRepository.findAll(PageRequest.of(pageNo, pageSize, sort));
        log.info("Get All Order with pagination");
        return setPageResponse.pageResponse(orders);
    }

    @Override
    public Order getOrderById(String id) {
        log.info("Finding Order With Id: {}", id);
        return orderRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("Order with id %s not found", id)));
    }

    @Override
    public Order saveOrder(Order order) {
        log.info("Saving Order {}", order);
        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(String id, Order order) {
        Order oldOrder = orderRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("Order with id %s not found", id)));
        log.info("Updating Order {}", order);
        oldOrder.setCartId(order.getCartId());
        return orderRepository.save(oldOrder);
    }

    @Override
    public boolean deleteOrder(String id) {
        log.info("Deleting Order with id {}", id);
        Order delete = orderRepository.findById(id).orElseThrow(() -> new NotFoundException(String.format("Order with id %s not found", id)));
        orderRepository.delete(delete);
        return Boolean.TRUE;
    }
}
