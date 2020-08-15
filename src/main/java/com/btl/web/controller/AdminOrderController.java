package com.btl.web.controller;

import com.btl.web.entity.Order;
import com.btl.web.entity.OrderProduct;
import com.btl.web.entity.Product;
import com.btl.web.model.OrderDetailModel;
import com.btl.web.service.OrderProductService;
import com.btl.web.service.OrderService;
import com.btl.web.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class AdminOrderController {
    @Autowired
    OrderProductService orderProductService;
    @Autowired
    OrderService orderService;
    @Autowired
    ProductService productService;

    @GetMapping("/admin/orders")
    public String listOrder(Model model) {
//        List<OrderProduct> orderProducts = orderProductService.getAll();
        List<Order> orders = orderService.getAll();
        model.addAttribute("orders",orders);
        return  "admin-list-order";
    }

    @GetMapping("/admin/orders/{id}")
    public String getOrderById(@PathVariable int id, Model model) {
        List<OrderProduct> orderProduct = orderProductService.findById(id);
        Optional<Product> product = productService.findProductById(orderProduct.get(0).getProductId());
        Optional<Order> order = orderService.getById(orderProduct.get(0).getOrderId());

        ModelMapper modelMapper = new ModelMapper();
        OrderDetailModel orderDetailModel = modelMapper.map(order.get(), OrderDetailModel.class);
        orderDetailModel.setProduct(product.get());
        model.addAttribute("order", orderDetailModel);

        return "admin-order-detail";
    }
}
