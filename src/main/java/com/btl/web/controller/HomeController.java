package com.btl.web.controller;

import com.btl.web.entity.Category;
import com.btl.web.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private CategoryService categoryService;

    public void getAllCategory(Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
    }

    @GetMapping("/")
    public String index(Model model) {
        getAllCategory(model);
        List<Category> categories = (List<Category>) model.getAttribute("categories");

        return "index";
    }
}
