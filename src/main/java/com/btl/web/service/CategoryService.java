package com.btl.web.service;

import com.btl.web.entity.Category;
import com.btl.web.entity.Product;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    public List<Category> findAll();
}
