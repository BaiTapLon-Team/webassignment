package com.btl.web.controller;

import com.btl.web.entity.Category;
import com.btl.web.entity.Order;
import com.btl.web.entity.OrderProduct;
import com.btl.web.entity.Product;
import com.btl.web.model.OrderModelRequest;
import com.btl.web.service.CategoryService;
import com.btl.web.service.OrderProductService;
import com.btl.web.service.OrderService;
import com.btl.web.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderProductService orderProductService;

    public void getAllCategory(Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
    }

    @GetMapping("/product")
    private String test(){
        List<Product> products = productService.getAllProducts();
        for (Product product : products) {
            System.out.println(product.toString());
        }
        return "index";
    }

    @GetMapping("/product/{productPath}")
    private String getById(Model model, @PathVariable String productPath ) {
        getAllCategory(model);
        String paths [] = productPath.split("-");
        int id = Integer.parseInt(paths[paths.length - 1]);
        Optional<Product> optionalProduct = productService.findProductById(id);
        if(optionalProduct.isEmpty()) {
            // 404 not found
        }else {
            model.addAttribute("product", optionalProduct.get());
            model.addAttribute("order", new OrderModelRequest());
        }
        return "detail";
    }

    @PostMapping("/product/order")
    private String order(@ModelAttribute("order") OrderModelRequest orderRequest) {
        Optional<Product> optionalProduct = productService.findProductById(orderRequest.getProductId());
        if(!optionalProduct.isEmpty()) {
            ModelMapper modelMapper = new ModelMapper();
            Order order = modelMapper.map(orderRequest, Order.class);
            order.setCreatedOn(new Date(System.currentTimeMillis()));
            order.setModifiedOn(new Date(System.currentTimeMillis()));
            order.setTotalAmount(new BigDecimal(optionalProduct.get().getPrice()));
            order.setStatus("active");
            Order orderResponse = orderService.createOrder(order);
            OrderProduct orderProduct = new OrderProduct(orderResponse.getId(), optionalProduct.get().getId(), 1, new BigDecimal(optionalProduct.get().getPrice()));
            OrderProduct orderProductResponse = orderProductService.save(orderProduct);
        }
        return "redirect:/";
    }


}
