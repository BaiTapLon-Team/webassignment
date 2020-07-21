package com.btl.web.service.serviceimpl;

import com.btl.web.entity.Product;
import com.btl.web.reponsitory.ProductReponsitory;
import com.btl.web.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductReponsitory productReponsitory;

    @Override
    public List<Product> getAllProducts () {
        return productReponsitory.findAll();
    }

    @Override
    public Optional<Product> findProductById (Integer id) {
        return productReponsitory.findById(id);
    }

    @Override
    public void saveProduct ( Product product ) {
        productReponsitory.save(product);
    }

    @Override
    public void deleteProduct ( Integer id ) {
        productReponsitory.deleteById(id);
    }
}
