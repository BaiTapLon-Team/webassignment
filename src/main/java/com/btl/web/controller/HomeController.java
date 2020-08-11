package com.btl.web.controller;

import com.btl.web.entity.Category;
import com.btl.web.entity.Product;
import com.btl.web.service.CategoryService;
import com.btl.web.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;

    public void getAllCategory(Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
    }

    @GetMapping("/")
    public String index(Model model) {
        getAllCategory(model);
        List<Category> categories = (List<Category>) model.getAttribute("categories");
        for(Category category: categories) {
            if(category.getParentId() == 0) {
                System.out.println("Category: "+category.getName());
                for(Category subCategory : categories) {
                    if(category.getId() == subCategory.getParentId()) {
                        System.out.println("=> SubCategory: "+subCategory.getName());
                    }
                }
            }
        }
        List<Product> products =  productService.getAllProducts();
        model.addAttribute("products", products);
        System.out.println(products);
        return "index";
    }
}
