package com.btl.web.controller;

import com.btl.web.entity.Order;
import com.btl.web.entity.OrderProduct;
import com.btl.web.service.OrderProductService;
import com.btl.web.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdminOrderController {
    @Autowired
    OrderProductService orderProductService;
    @Autowired
    OrderService orderService;

    @GetMapping("/admin/orders")
    public String listOrder(Model model) {
//        List<OrderProduct> orderProducts = orderProductService.getAll();
        List<Order> orders = orderService.getAll();
        model.addAttribute("orders",orders);
        return  "admin-list-order";
    }
}
