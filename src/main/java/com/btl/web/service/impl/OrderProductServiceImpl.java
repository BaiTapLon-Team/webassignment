package com.btl.web.service.impl;

import com.btl.web.entity.OrderProduct;
import com.btl.web.repository.OrderProductRepository;
import com.btl.web.service.OrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderProductServiceImpl implements OrderProductService {

    @Autowired
    OrderProductRepository orderProductRepository;

    @Override
    public OrderProduct save(OrderProduct orderProduct) {
        return orderProductRepository.save(orderProduct);
    }

    @Override
    public List<OrderProduct> getAll() {
        return null;
    }

    @Override
    public Optional<OrderProduct> findById(int id) {
        return Optional.empty();
    }
}
