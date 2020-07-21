package com.btl.web.reponsitory;

import com.btl.web.entity.Category2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface Category2Reponsitory extends JpaRepository<Category2, Integer> {
}
