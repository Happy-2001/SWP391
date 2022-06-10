/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Admin
 */
public class Cart {
    private int item_id;
    private int product_id;
    private String product_name;
    private String url;
    private int unit_price;
    private int quantity;
    private int Cart_user_id;

    public Cart() {
    }

    public Cart(int item_id, int product_id, String product_name, String url, int unit_price, int quantity, int Cart_user_id) {
        this.item_id = item_id;
        this.product_id = product_id;
        this.product_name = product_name;
        this.url = url;
        this.unit_price = unit_price;
        this.quantity = quantity;
        this.Cart_user_id = Cart_user_id;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(int unit_price) {
        this.unit_price = unit_price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCart_user_id() {
        return Cart_user_id;
    }

    public void setCart_user_id(int Cart_user_id) {
        this.Cart_user_id = Cart_user_id;
    }

    
    
}
