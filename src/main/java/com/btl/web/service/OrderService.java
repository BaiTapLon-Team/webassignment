package com.btl.web.service;

import com.btl.web.entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface OrderService {
    Order createOrder(Order order);
    Optional<Order> getById(int id);
    List<Order> getAll();
}
