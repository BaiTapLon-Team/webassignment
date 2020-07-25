package com.btl.web.controller;

import com.btl.web.entity.Category;
import com.btl.web.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/")
    public String test() {
        List<Category> categories = categoryService.findAll();
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
        return "index";
    }
}
