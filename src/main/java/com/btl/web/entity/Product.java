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

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", description='" + description + '\'' +
                ", createdOn=" + createdOn +
                ", modifiedOn=" + modifiedOn +
                ", status='" + status + '\'' +
                ", cpu='" + cpu + '\'' +
                ", ram='" + ram + '\'' +
                ", hardDisk='" + hardDisk + '\'' +
                ", screen='" + screen + '\'' +
                ", portConnect='" + portConnect + '\'' +
                ", weight='" + weight + '\'' +
                ", pin='" + pin + '\'' +
                ", os='" + os + '\'' +
                ", busRam='" + busRam + '\'' +
                ", brand='" + brand + '\'' +
                ", productImages=" + productImages +
                '}';
    }
}
