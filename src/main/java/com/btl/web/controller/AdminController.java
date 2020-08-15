package com.btl.web.controller;

import com.btl.web.entity.Category;
import com.btl.web.entity.Product;
import com.btl.web.entity.User;
import com.btl.web.service.CategoryService;
import com.btl.web.service.ProductService;
import com.btl.web.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.support.NullValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
public class AdminController {
    @Autowired
    UserService userService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;


    public void getAllCategory(Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
    }


    @GetMapping(value = "/admin")
    public String login( Model model, HttpSession session) {
        if(session.getAttribute("admin") != null) {
            return "redirect:/admin/list-product";
        }
        getAllCategory(model);
        model.addAttribute("invalid", false);
        return "login";
    }


    @RequestMapping( value = "/admin", method = RequestMethod.POST)
    public String authorzation( Model model, @RequestParam(value = "email") String email,
                                @RequestParam(value = "password") String password, HttpSession session) {
        List<User> admin = userService.findByEmailAndPassword(email, password);
        if(!admin.isEmpty()) {
            session.setAttribute("admin", admin.get(0));
            return "redirect:/admin/list-product";
        }
        model.addAttribute("invalid", true);
        return "login";
    }

    @GetMapping(value = "/admin/list-product")
    public String getListProduct(Model model, HttpSession httpSession) {
        if(httpSession.getAttribute("admin") == null) {
            return "redirect:/admin";
        }
        List<Product> productList = productService.getAllProducts();
        model.addAttribute("products", productList);
        return "admin-list-product";
    }

    @RequestMapping(value = "/admin/list-product", method = RequestMethod.POST)
    public String searchAdmin(Model model, HttpSession httpSession, @RequestParam(value = "search") String search) {
        if(httpSession.getAttribute("admin") == null) {
            return "redirect:/admin";
        }
        List<Product> productList = productService.findAllByNameLike(search);
        model.addAttribute("products", productList);
        return "admin-list-product";
    }

}
