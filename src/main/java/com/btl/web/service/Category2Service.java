package com.btl.web.service;

import com.btl.web.entity.Category2;

import java.util.List;
import java.util.Optional;

public interface Category2Service {
    public List<Category2> findAll();
    public Optional<Category2> findCategory2ById(Integer id);
}
