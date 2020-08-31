package com.btl.web.controller;

import com.btl.web.entity.Category;
import com.btl.web.entity.ProductImages;
import com.btl.web.service.ProductImagesService;
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
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductImagesService productImagesService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderProductService orderProductService;


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

    @GetMapping("/product/{productPath}")
    private String getById(Model model, @PathVariable String productPath ) {
        getAllCategory(model);
        String paths [] = productPath.split("-");
        int id = Integer.parseInt(paths[paths.length - 1]);
        Optional<Product> optionalProduct = productService.findProductById(id);
//        if(optionalProduct.isEmpty()) {
//            // 404 not found
        if(optionalProduct==null) {
            return "detail";
//            // 404 not found
        }else {
            model.addAttribute("product", optionalProduct.get());
            model.addAttribute("order", new OrderModelRequest());
        }
        return "detail";
    }

    @PostMapping("/product/order")
    private String order(@ModelAttribute("order") OrderModelRequest orderRequest) {
        Optional<Product> optionalProduct = productService.findProductById(orderRequest.getProductId());
        if(optionalProduct != null) {
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
