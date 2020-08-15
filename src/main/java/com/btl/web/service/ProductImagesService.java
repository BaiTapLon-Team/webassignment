package com.btl.web.service;

import com.btl.web.entity.ProductImages;
import com.btl.web.repository.ProductImagesRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProductImagesService {
    public List<ProductImages> findByImage1AndImage2( String image1, String image2);

    public void saveProductImages(ProductImages productImages);
}
