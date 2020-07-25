package com.btl.web.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

public class OrderProductPK  implements Serializable {
    private int orderId;
    private int productId;

    @Column(name = "OrderId")
    @Id
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Column(name = "ProductId")
    @Id
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderProductPK that = (OrderProductPK) o;
        return productId == that.productId &&
                orderId == that.productId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, orderId);
    }
}
