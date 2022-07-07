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
public class Suppliers {
    private int id;
    private String name;
    private String contactName;
    private String contactTitle;
    private Date dob;
    private int gender;
    private int creator;

    public Suppliers(){
        
    }
    public Suppliers(int id, String name, String contactName, String contactTitle, Date dob, int gender, int creator) {
        this.id = id;
        this.name = name;
        this.contactName = contactName;
        this.contactTitle = contactTitle;
        this.dob = dob;
        this.gender = gender;
        this.creator = creator;
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

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactTitle() {
        return contactTitle;
    }

    public void setContactTitle(String contactTitle) {
        this.contactTitle = contactTitle;
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

    @Override
    public String toString() {
        return "Suppliers{" + "id=" + id + ", name=" + name + ", contactName=" + contactName + ", contactTitle=" + contactTitle + ", dob=" + dob + ", gender=" + gender + ", creator=" + creator + '}';
    }
    
    
}
