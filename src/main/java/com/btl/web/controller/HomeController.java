package com.btl.web.controller;

import com.btl.web.entity.Category;
import com.btl.web.entity.Product;
import com.btl.web.service.CategoryService;
import com.btl.web.service.ProductService;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
        List<Product> products =  productService.getAllProducts();
        model.addAttribute("products", products);
        return "index";
    }

    @GetMapping("/{categogyPath}" )
    public String getListFollowCategogy( Model model, @PathVariable String categogyPath ) {
        getAllCategory(model);
        List<Category> categories = (List<Category>) model.getAttribute("categories");
        String [] s = categogyPath.split("-");
        int categoryId = Integer.parseInt(s[1]);
        List<Product> products = productService.findProductsByCategoryId(categoryId);
        model.addAttribute("products", products);
        return "index";
    }

    @GetMapping(value = "/", params = "search")
    public String getListSearch ( Model model, @RequestParam(value = "search") String search ) {
        getAllCategory(model);
        List<Category> categories = (List<Category>) model.getAttribute("categories");
        List<Product> products = productService.findAllByNameLike(search);
        model.addAttribute("products", products);
        System.out.println(products);;
        return "index";
    }
}
