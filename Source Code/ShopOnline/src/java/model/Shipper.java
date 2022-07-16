/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author nguye
 */
public class Shipper {
    private int id;
    private String name;;
    private Date dob;
    private int gender;
    private int creator;
    private Date createOn;
    private Date updateOn;
    
    public Shipper(){
        
    }

    public Shipper(int id, String name, Date dob, int gender, int creator, Date createOn, Date updateOn) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.creator = creator;
        this.createOn = createOn;
        this.updateOn = updateOn;
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getCreator() {
        return creator;
    }

    public void setCreator(int creator) {
        this.creator = creator;
    }

    public Date getCreateOn() {
        return createOn;
    }

    public void setCreateOn(Date createOn) {
        this.createOn = createOn;
    }

    public Date getUpdateOn() {
        return updateOn;
    }

    public void setUpdateOn(Date updateOn) {
        this.updateOn = updateOn;
    }

    @Override
    public String toString() {
        return "Shipper{" + "id=" + id + ", name=" + name + ", dob=" + dob + ", gender=" + gender + ", creator=" + creator + ", creatorOn=" + createOn + ", updateOn=" + updateOn + '}';
    }
    
}
