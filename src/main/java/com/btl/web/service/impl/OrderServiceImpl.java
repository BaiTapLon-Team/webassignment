package com.btl.web.service.impl;

import com.btl.web.entity.Order;
import com.btl.web.repository.OrderRepository;
import com.btl.web.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order getById(int id) {
        return null;
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }
}
