package com.btl.web.repository;

import com.btl.web.entity.Category;
import com.btl.web.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    public List<Category> findByParentIdAndName(int parentid, String name);
}
