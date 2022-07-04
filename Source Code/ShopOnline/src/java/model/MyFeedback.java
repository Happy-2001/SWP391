/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author dungk
 */
public class MyFeedback {

    private int fbID;
    private String photo1;
    private String photo2;
    private String description;
    private String note;
    private int status;
    User user;
    Product product;
    private String createDate;
    private String updateDate;
    private int rating;

    public MyFeedback() {
    }

    public MyFeedback(int fbID, String photo1, String photo2, String description, String note, int status, User user, Product product, String createDate, String updateDate, int rating) {
        this.fbID = fbID;
        this.photo1 = photo1;
        this.photo2 = photo2;
        this.description = description;
        this.note = note;
        this.status = status;
        this.user = user;
        this.product = product;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.rating = rating;
    }

    public int getFbID() {
        return fbID;
    }

    public void setFbID(int fbID) {
        this.fbID = fbID;
    }

    public String getPhoto1() {
        return photo1;
    }

    public void setPhoto1(String photo1) {
        this.photo1 = photo1;
    }

    public String getPhoto2() {
        return photo2;
    }

    public void setPhoto2(String photo2) {
        this.photo2 = photo2;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

}
