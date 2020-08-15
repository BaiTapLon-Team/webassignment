package com.btl.web.service.impl;

import com.btl.web.entity.Product;
import com.btl.web.repository.ProductRepository;
import com.btl.web.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts () {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findProductById (Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public void saveProduct ( Product product ) {
        productRepository.save(product);
    }


    @Override
    public List<Product> findProductsByCategoryId (int categoryId) {
        return productRepository.findAllByCategory_Id(categoryId);
    }

    @Override
    public List<Product> findAllByNameLike ( String keyWord ) {
        keyWord = "%"+keyWord+"%";
        return productRepository.findAllByNameLike(keyWord);
    }
}
