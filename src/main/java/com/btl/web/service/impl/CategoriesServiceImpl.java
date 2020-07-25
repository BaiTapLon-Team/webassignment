package com.btl.web.service.impl;

import com.btl.web.entity.Category;
import com.btl.web.repository.CategoryRepository;
import com.btl.web.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriesServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll () {
       return categoryRepository.findAll();
    }
}
