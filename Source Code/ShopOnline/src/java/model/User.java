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
public class User {
    private int userid;
    private String username;
    String password;
    String firstname;
    String middlename;
    String lastname;
    Date dob;

    private String photo;
    int gender;
    private String phone;
    private String email;
    private int status;
    
    Role authority;

    public User() {
    }

    public User(int userid, String username, String firstname, String middlename, String lastname,  int gender, Date dob, int status, String email, String phone, String photo, Role authority) {
        this.userid = userid;
        this.username = username;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.dob = dob;
        this.photo = photo;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.status = status;
        this.authority = authority;
    }
    
    public User(int userid, String username, String password, String firstname, String middlename, String lastname, String photo, int gender, String phone, String email, int status, Role authority) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.photo = photo;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.status = status;
        this.authority = authority;
    }
    
    public User(int userid, String firstname, String middlename, String lastname) {
        this.userid = userid;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
    }
    
    public User(int userid, String username, String firstname, String middlename, String lastname, String photo, String email) {
        this.userid = userid;
        this.username = username;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.photo = photo;
        this.email = email;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
    

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Role getAuthority() {
        return authority;
    }

    public void setAuthority(Role authority) {
        this.authority = authority;
    }
    
    public String getFullname(){
        return (firstname+" "+middlename+" "+lastname).trim();
    }

    public String getCode() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setCode(String random) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
