package com.btl.web.service;

import com.btl.web.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    public List<Category> findAll();
    public Optional<Category> findCategoryById( int id);
    public List<Category> findByParentIdAndName(int parentid, String name);
}
