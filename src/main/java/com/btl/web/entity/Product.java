package com.btl.web.entity;


import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productid;

    @Column(name = "adminid")
    private Integer adminid;

    @ManyToOne
    @JoinColumn(name = "categoryid2")
    Category2 category2;

    @OneToOne
    @JoinColumn(name = "productimgid")
    ProductImage productImage;

    @Column(name = "productname")
    private String  productname;

    @Column(name = "productprice")
    private String productprice;

    @Column (name = "productdescription")
    private String productdescription;

    @Column(name = "cpu")
    private String cpu;

    @Column(name = "ram")
    private String ram;

    @Column(name = "harddisk")
    private String harddisk;

    @Column(name = "vga")
    private String vga;

    @Column(name = "screen")
    private String screen;

    @Column(name = "portconnect")
    private String portconnect;

    @Column(name = "weigth")
    private String weigth;

    @Column(name = "pin")
    private String pin;

    @Column(name = "os")
    private String os;


    public Product () {
    }

    public Integer getProductid () {
        return productid;
    }

    public void setProductid ( Integer productid ) {
        this.productid = productid;
    }

    public Integer getAdminid () {
        return adminid;
    }

    public void setAdminid ( Integer adminid ) {
        this.adminid = adminid;
    }

    public Category2 getCategory2 () {
        return category2;
    }

    public void setCategory2 ( Category2 category2 ) {
        this.category2 = category2;
    }

    public String getProductname () {
        return productname;
    }

    public void setProductname ( String productname ) {
        this.productname = productname;
    }

    public String getProductprice () {
        return productprice;
    }

    public void setProductprice ( String productprice ) {
        this.productprice = productprice;
    }

    public String getProductdescription () {
        return productdescription;
    }

    public void setProductdescription ( String productdescription ) {
        this.productdescription = productdescription;
    }

    public String getCpu () {
        return cpu;
    }

    public void setCpu ( String cpu ) {
        this.cpu = cpu;
    }

    public String getRam () {
        return ram;
    }

    public void setRam ( String ram ) {
        this.ram = ram;
    }

    public String getHarddisk () {
        return harddisk;
    }

    public void setHarddisk ( String harddisk ) {
        this.harddisk = harddisk;
    }

    public String getVga () {
        return vga;
    }

    public void setVga ( String vga ) {
        this.vga = vga;
    }

    public String getScreen () {
        return screen;
    }

    public void setScreen ( String screen ) {
        this.screen = screen;
    }

    public String getPortconnect () {
        return portconnect;
    }

    public void setPortconnect ( String portconnect ) {
        this.portconnect = portconnect;
    }

    public String getWeigth () {
        return weigth;
    }

    public void setWeigth ( String weigth ) {
        this.weigth = weigth;
    }

    public String getPin () {
        return pin;
    }

    public void setPin ( String pin ) {
        this.pin = pin;
    }

    public String getOs () {
        return os;
    }

    public void setOs ( String os ) {
        this.os = os;
    }

    public ProductImage getProductImage () {
        return productImage;
    }

    public void setProductImage ( ProductImage productImage ) {
        this.productImage = productImage;
    }
}
