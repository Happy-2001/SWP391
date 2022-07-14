/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author Administrator
 */
public class Blog {
    private int id;
    private String createdDate;
    private String content;
    private String description;
    private String noidung;
    private String image;
    private int categoryId;
    private int uid;

    public Blog() {
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public Blog(String createdDate, String content, String description, String noidung, String image, int categoryId, int uid) {
        this.createdDate = createdDate;
        this.content = content;
        this.description = description;
        this.noidung = noidung;
        this.image = image;
        this.categoryId = categoryId;
        this.uid = uid;
    }

    public Blog(int id, String createdDate, String content, String description, String noidung, String image, int categoryId, int uid) {
        this.id = id;
        this.createdDate = createdDate;
        this.content = content;
        this.description = description;
        this.noidung = noidung;
        this.image = image;
        this.categoryId = categoryId;
        this.uid = uid;
    }

    public Blog(int id, String createdDate, String content, String description, String image, int categoryId) {
        this.id = id;
        this.createdDate = createdDate;
        this.content = content;
        this.description = description;
        this.image = image;
        this.categoryId = categoryId;
    }

    public Blog(int id, String createdDate, String content, String description, String image) {
        this.id = id;
        this.createdDate = createdDate;
        this.content = content;
        this.description = description;
        this.image = image;
        this.categoryId = categoryId;
    }

    public Blog(int id, String createdDate, String content, String description, String noidung, String image, int categoryId) {
        this.id = id;
        this.createdDate = createdDate;
        this.content = content;
        this.description = description;
        this.noidung = noidung;
        this.image = image;
        this.categoryId = categoryId;
    }
    public Blog(String createdDate, String content, String description, String noidung, String image, int categoryId) {
        this.createdDate = createdDate;
        this.content = content;
        this.description = description;
        this.noidung = noidung;
        this.image = image;
        this.categoryId = categoryId;
    }
    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
