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
public class Supplier {

    private int id;
    private String name;
    private String contactName;
    private String contactTitle;
    private String dob;
    private int gender;
    private int creator;
    private String createOn;
    private String updateOn;

    public Supplier() {

    }

    public Supplier(String name, String contactName, String contactTitle, String dob, int gender, int creator) {
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
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

    public String getCreateOn() {
        return createOn;
    }

    public void setCreateOn(String createOn) {
        this.createOn = createOn;
    }

    public String getUpdateOn() {
        return updateOn;
    }

    public void setUpdateOn(String updateOn) {
        this.updateOn = updateOn;
    }

    public Supplier(int id, String name, String contactName, String contactTitle, String dob, int gender, int creator, String createOn, String updateOn) {
        this.id = id;
        this.name = name;
        this.contactName = contactName;
        this.contactTitle = contactTitle;
        this.dob = dob;
        this.gender = gender;
        this.creator = creator;
        this.createOn = createOn;
        this.updateOn = updateOn;
    }

}
