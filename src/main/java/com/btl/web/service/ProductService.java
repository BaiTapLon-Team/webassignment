package com.btl.web.service;


import com.btl.web.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    public List<Product> getAllProducts();
    public Optional<Product> findProductById(Integer id);
    public void saveProduct(Product product);
    public void deleteProduct(Integer id);
}
