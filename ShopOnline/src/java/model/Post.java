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
public class Post {
    private int post_id;
    private String date;
    private String content;
    private String brief_infor;
    private String description;
    private String noidung;
    private String image;
    private int categoryId;

    public Post() {
    }

    public Post(int post_id, String date, String content, String brief_infor, String description, String image) {
        this.post_id = post_id;
        this.date = date;
        this.content = content;
        this.brief_infor = brief_infor;
        this.description = description;
        this.image = image;
    }

    public Post(String date, String content, String description, String noidung, int categoryId, String image) {
        this.date = date;
        this.content = content;
        this.description = description;
        this.noidung = noidung;
        this.categoryId = categoryId;
        this.image = image;
    }
    
    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
    
    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getBrief_infor() {
        return brief_infor;
    }

    public void setBrief_infor(String brief_infor) {
        this.brief_infor = brief_infor;
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

    
    
}
