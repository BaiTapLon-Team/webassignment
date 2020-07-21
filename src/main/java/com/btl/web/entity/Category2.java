package com.btl.web.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "category2")
public class Category2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryid2;

    @ManyToOne
    @JoinColumn(name = "categoryid1")
    private Category1 categoryid1;

    @Column(name = "categoryname")
    private String categoryname;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category2")
    private Set<Product> products = new HashSet<Product>();

    public Integer getCategoryid2 () {
        return categoryid2;
    }

    public void setCategoryid2 ( Integer categoryid2 ) {
        this.categoryid2 = categoryid2;
    }

    public Category1 getCategoryid1 () {
        return categoryid1;
    }

    public void setCategoryid1 ( Category1 categoryid1 ) {
        this.categoryid1 = categoryid1;
    }

    public String getCategoryname () {
        return categoryname;
    }

    public void setCategoryname ( String categoryname ) {
        this.categoryname = categoryname;
    }

}
