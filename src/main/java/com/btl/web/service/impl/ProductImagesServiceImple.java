package com.btl.web.service.impl;

import com.btl.web.entity.ProductImages;
import com.btl.web.repository.ProductImagesRepository;
import com.btl.web.service.ProductImagesService;
import com.btl.web.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImagesServiceImple implements ProductImagesService {
    @Autowired
    ProductImagesRepository productImagesRepository;

    @Override
    public List<ProductImages> findByImage1AndImage2 ( String image1, String image2 ) {
        return productImagesRepository.findByImage1AndImage2(image1, image2);
    }

    @Override
    public void saveProductImages ( ProductImages productImages ) {
        productImagesRepository.save(productImages);
    }
}
