package com.btl.web.entity;

import javax.persistence.*;

@Entity
@Table(name = "productimages")
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productimgid;

    @Column(name = "productimage1")
    private String productimage1;

    @Column(name = "productimage2")
    private String productimage2;

    @Column(name = "productimage3")
    private String productimage3;

    @Column(name = "productimage4")
    private String productimage4;

    @Column(name = "productimage5")
    private String productimage5;

    public Integer getProductimgid () {
        return productimgid;
    }

    public void setProductimgid ( Integer productimgid ) {
        this.productimgid = productimgid;
    }

    public String getProductimage1 () {
        return productimage1;
    }

    public void setProductimage1 ( String productimage1 ) {
        this.productimage1 = productimage1;
    }

    public String getProductimage2 () {
        return productimage2;
    }

    public void setProductimage2 ( String productimage2 ) {
        this.productimage2 = productimage2;
    }

    public String getProductimage3 () {
        return productimage3;
    }

    public void setProductimage3 ( String productimage3 ) {
        this.productimage3 = productimage3;
    }

    public String getProductimage4 () {
        return productimage4;
    }

    public void setProductimage4 ( String productimage4 ) {
        this.productimage4 = productimage4;
    }

    public String getProductimage5 () {
        return productimage5;
    }

    public void setProductimage5 ( String productimage5 ) {
        this.productimage5 = productimage5;
    }
}
