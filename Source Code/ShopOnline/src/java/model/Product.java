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
    private int categoryid;
    private float price;
    private float salePrice;
    private int stock;
    private String brief_information;
    private String description;
    private String img;
    private String sortdesc;

    public Product() {
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
    public Product(int id, String name, float price, float salePrice, int stock, String brief_information, String description, String img) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.salePrice = salePrice;
        this.stock = stock;
        this.brief_information = brief_information;
        this.description = description;
        this.img = img;
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

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
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
        return "Product{" + "id=" + id + ", name=" + name + ", categoryid=" + categoryid + ", price=" + price + ", salePrice=" + salePrice + ", stock=" + stock + ", brief_information=" + brief_information + ", description=" + description + ", img=" + img + ", sortdesc=" + sortdesc + '}';
    }
}
