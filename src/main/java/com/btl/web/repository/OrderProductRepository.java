package com.btl.web.repository;

import com.btl.web.entity.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import com.btl.web.entity.OrderProductPK;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProduct, OrderProductPK> {
    List<OrderProduct> findByOrderId(int id);
}
