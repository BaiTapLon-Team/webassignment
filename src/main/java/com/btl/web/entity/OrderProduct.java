package com.btl.web.entity;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "OrderProduct")
@IdClass(OrderProductPK.class)
public class OrderProduct {
    @Id
    @Column(name = "ProductId")
    private Integer productId;

    @Id
    @Column(name = "OrderId")
    private Integer orderId;

    private int quantity;
    private BigDecimal totalAmount;

    public OrderProduct() {
    }

    public OrderProduct(int orderId, int productId, int quantity, BigDecimal totalAmount) {
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}