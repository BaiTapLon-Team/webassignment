package com.btl.web.entity;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "CategoryId")
    private Category category;

    private String description;
    private Date createdOn;
    private Date modifiedOn;
    private String status;
    private String cpu;
    private String ram;
    private String hardDisk;
    private String screen;
    private String portConnect;
    private String weight;
    private String pin;
    private String os;
    private String busRam;
    private String brand;

    @ManyToOne
    @JoinColumn(name = "ProductImagesId")
    private ProductImages productImages;

    public Product () {
    }


}
