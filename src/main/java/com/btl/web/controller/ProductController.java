package com.btl.web.controller;

import com.btl.web.entity.Product;
import com.btl.web.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

//    @GetMapping("/product")
//    private ResponseEntity<?> getAllProduct( ModelAndView modelAndView ) {
//        modelAndView.setViewName("index");
//        List<Product> products =  productService.getAllProducts();
//        modelAndView.addObject("products", products);
//        return  new ResponseEntity<>(products, HttpStatus.OK);
//    }

    @GetMapping("/product")
    private String test(){
        List<Product> products = productService.getAllProducts();
        for (Product product : products) {
            System.out.println(product.toString());
        }
        return "index";
    }


}
