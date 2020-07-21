package com.btl.web.controller;

import com.btl.web.entity.Product;
import com.btl.web.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    private ResponseEntity<?> getAllProduct( ModelAndView modelAndView ) {
        modelAndView.setViewName("index");
        List<Product> products =  productService.getAllProducts();
        modelAndView.addObject("products", products);
        return  new ResponseEntity<>(products, HttpStatus.OK);
    }
}
