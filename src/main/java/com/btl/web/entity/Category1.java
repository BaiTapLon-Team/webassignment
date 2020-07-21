package com.btl.web.entity;

import javax.persistence.*;

@Entity
@Table(name = "category1")
public class Category1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryid1;

    @Column(name = "categoryname")
    private String categoryname;

    public Integer getCategoryid1 () {
        return categoryid1;
    }

    public void setCategoryid1 ( Integer categoryid1 ) {
        this.categoryid1 = categoryid1;
    }

    public String getCategoryname () {
        return categoryname;
    }

    public void setCategoryname ( String categoryname ) {
        this.categoryname = categoryname;
    }
}
