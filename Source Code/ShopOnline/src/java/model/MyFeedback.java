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

    private int feedback_id;
    private int userid;
    private String full_name;
    private String url;
    private String product_name;
    private int star_rating;
    private String description;
    private String note;
    private String usemail;
    private int phone;
    private int status;

    public MyFeedback() {
    }

    public MyFeedback(int feedback_id, int userid, String full_name, String url, String product_name, int star_rating, String description, String note, String usemail, int phone, int status) {
        this.feedback_id = feedback_id;
        this.userid = userid;
        this.full_name = full_name;
        this.url = url;
        this.product_name = product_name;
        this.star_rating = star_rating;
        this.description = description;
        this.note = note;
        this.usemail = usemail;
        this.phone = phone;
        this.status = status;
    }

    public int getFeedback_id() {
        return feedback_id;
    }

    public void setFeedback_id(int feedback_id) {
        this.feedback_id = feedback_id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getStar_rating() {
        return star_rating;
    }

    public void setStar_rating(int star_rating) {
        this.star_rating = star_rating;
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

    public String getUsemail() {
        return usemail;
    }

    public void setUsemail(String usemail) {
        this.usemail = usemail;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    

    @Override
    public String toString() {
        return "MyFeedback{" + "feedback_id=" + feedback_id + ", userid=" + userid + ", full_name=" + full_name + ", url=" + url + ", product_name=" + product_name + ", star_rating=" + star_rating + ", description=" + description + ", note=" + note + ", usemail=" + usemail + ", phone=" + phone + ", status=" + status + '}';
    }


}
