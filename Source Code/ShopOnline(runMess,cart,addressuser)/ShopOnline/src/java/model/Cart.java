package model;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class Cart {
    int itemId;
    Product product;
    int quantity;
    String status,selected;
    Date createDate;
    Date updateDate;
    int userId;
    String cartID;

    public Cart() {
    }

    public Cart(int itemId, Product product, int quantity, String status, Date createDate, Date updateDate, int userId,String selected,String cartID) {
        this.itemId = itemId;
        this.product = product;
        this.quantity = quantity;
        this.status = status;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.userId = userId;
        this.selected= selected;
        this.cartID= cartID;
    }

    public String getCartID() {
        return cartID;
    }

    public void setCartID(String cartID) {
        this.cartID = cartID;
    }

    public String getSelected() {
        return selected;
    }

    public void setSelected(String selected) {
        this.selected = selected;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

}
