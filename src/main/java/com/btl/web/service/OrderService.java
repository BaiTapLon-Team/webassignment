package com.btl.web.service;

import com.btl.web.entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    Order createOrder(Order order);
    Order getById(int id);
    List<Order> getAll();
}
