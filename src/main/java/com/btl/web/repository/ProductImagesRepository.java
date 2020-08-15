package com.btl.web.repository;

import com.btl.web.entity.ProductImages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductImagesRepository extends JpaRepository<ProductImages, Integer> {
    public List<ProductImages> findByImage1AndImage2(String image1, String image2);
}
