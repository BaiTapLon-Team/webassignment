package com.btl.web.controller;

import com.btl.web.entity.Category;
import com.btl.web.entity.Product;
import com.btl.web.entity.ProductImages;
import com.btl.web.service.CategoryService;
import com.btl.web.service.ProductImagesService;
import com.btl.web.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductImagesService productImagesService;

    public void getAllCategory(Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
    }

    @GetMapping("/admin/product/{id}")
    public String ngungBan( Model model, HttpSession httpSession, @PathVariable(value = "id")int id ){
        if(httpSession.getAttribute("admin") == null) {
            return "redirect:/admin";
        }
        Optional<Product> product = productService.findProductById(id);
        if(product.get().getStatus().equals("on")) {
            product.get().setStatus("off");
        } else {
            product.get().setStatus("on");
        }
        productService.saveProduct(product.get());
        List<Product> productList = productService.getAllProducts();
        model.addAttribute("products", productList);
        return "redirect:/admin/list-product";
    }

    @GetMapping(value = "/product")
    public String hienThiThemProduct(Model model, HttpSession httpSession) {
//        if(httpSession.getAttribute("admin") == null) {
////            return "redirect:/admin";
////        }
        Product product = new Product();
        ProductImages productImages = new ProductImages();
        model.addAttribute("product", product);
        model.addAttribute("error", " ");
        return "admin-create-product";
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public String hienThiThemProduct(Model model, HttpSession httpSession, @ModelAttribute(value = "product") Product product,
                                     @RequestParam(value = "parentid") int parentId, @RequestParam(value = "nameCategory") String nameCategory) {
//        if(httpSession.getAttribute("admin") == null) {
//            return "redirect:/admin";
//        }
        try {
            ProductImages productImages = product.getProductImages();
            Category category = categoryService.findByParentIdAndName(parentId, nameCategory).get(0);
            if(category != null) {
                product.setCategory(category);
                productImagesService.saveProductImages(product.getProductImages());
                productImages = productImagesService.findByImage1AndImage2(product.getProductImages().getImage1(), product.getProductImages().getImage2()).get(0);
                product.setProductImages(productImages);
                productService.saveProduct(product);
                model.addAttribute("error", " ");
                return "admin-create-product";
            }
            model.addAttribute("error", "Vui lòng nhập đầy đủ");
            return "admin-create-product";
        } catch (Exception ex) {
            model.addAttribute("error", "Vui lòng nhập đầy đủ");
            return "admin-create-product";
        }
    }

}
