package com.btl.web.service;

import com.btl.web.entity.OrderProduct;

import java.util.List;
import java.util.Optional;

public interface OrderProductService {
    OrderProduct save(OrderProduct orderProduct);
    List<OrderProduct> getAll();
    List<OrderProduct> findById(int id);
}
