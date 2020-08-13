package com.btl.web.repository;

import com.btl.web.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    public List<Product> findAllByCategory_Id( Integer categoryID);

    public List<Product> findAllByNameLike(String keyWord);
}
