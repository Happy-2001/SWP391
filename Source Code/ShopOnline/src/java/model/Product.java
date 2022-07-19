/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Administrator
 */
public class Product {

    private int id;
    private String name;
    Category category;
    private float price;
    private float salePrice;
    private int stock;
    private String brief_information;
    private String description;
    private String img;
    private String sortdesc;
    private String supplierID,view,like;
    
    public Product() {
    }
    
    public Product(Category category) {
        this.category = category;
    }
    
    public Product(String name, float salePrice, String img) {
        this.name = name;
        this.salePrice = salePrice;
        this.img = img;
    }

    public Product(int id, String name, float price, int stock, String description, String img) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.description = description;
        this.img = img;
    }

    public Product(int id, String name, float price, int stock, String description, String img, String sortdesc) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.description = description;
        this.img = img;
        this.sortdesc = sortdesc;
    }
    
    public Product(int id, String name, Category category, float price, float salePrice, int stock, String brief_information, String description, String img) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.salePrice = salePrice;
        this.stock = stock;
        this.brief_information = brief_information;
        this.description = description;
        this.img = img;
    }

    public Product(int id, String name, Category category, float price, float salePrice, int stock, String brief_information, String description, String img, String sortdesc, String supplierID) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.salePrice = salePrice;
        this.stock = stock;
        this.brief_information = brief_information;
        this.description = description;
        this.img = img;
        this.sortdesc = sortdesc;
        this.supplierID = supplierID;
    }

    public Product(int id, String name, Category category, float price, float salePrice, int stock, String brief_information, String description, String img, String sortdesc, String supplierID, String view, String like) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.salePrice = salePrice;
        this.stock = stock;
        this.brief_information = brief_information;
        this.description = description;
        this.img = img;
        this.sortdesc = sortdesc;
        this.supplierID = supplierID;
        this.view = view;
        this.like = like;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public String getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
    }
    
    public float getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(float salePrice) {
        this.salePrice = salePrice;
    }

    public String getBrief_information() {
        return brief_information;
    }

    public void setBrief_information(String brief_information) {
        this.brief_information = brief_information;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getSortdesc() {
        return sortdesc;
    }

    public void setSortdesc(String sortdesc) {
        this.sortdesc = sortdesc;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", price=" + price + ", salePrice=" + salePrice + ", stock=" + stock + ", brief_information=" + brief_information + ", description=" + description + ", img=" + img + ", sortdesc=" + sortdesc + '}';
    }

}