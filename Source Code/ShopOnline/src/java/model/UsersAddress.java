/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author nguye
 */
public class UsersAddress {
    private String uaID,userID,pname,dname,wname,prname,strname,detailAdress,phone,email,fullname,otherPhone,status;
    public UsersAddress(){
        
    }

    public UsersAddress(String uaID, String userID, String pname, String dname, String wname, String prname, String strname, String detailAdress, String phone, String email, String fullname, String otherPhone, String status) {
        this.uaID = uaID;
        this.userID = userID;
        this.pname = pname;
        this.dname = dname;
        this.wname = wname;
        this.prname = prname;
        this.strname = strname;
        this.detailAdress = detailAdress;
        this.phone = phone;
        this.email = email;
        this.fullname = fullname;
        this.otherPhone = otherPhone;
        this.status = status;
    }

    public String getUaID() {
        return uaID;
    }

    public void setUaID(String uaID) {
        this.uaID = uaID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getWname() {
        return wname;
    }

    public void setWname(String wname) {
        this.wname = wname;
    }

    public String getPrname() {
        return prname;
    }

    public void setPrname(String prname) {
        this.prname = prname;
    }

    public String getStrname() {
        return strname;
    }

    public void setStrname(String strname) {
        this.strname = strname;
    }

    public String getDetailAdress() {
        return detailAdress;
    }

    public void setDetailAdress(String detailAdress) {
        this.detailAdress = detailAdress;
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

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getOtherPhone() {
        return otherPhone;
    }

    public void setOtherPhone(String otherPhone) {
        this.otherPhone = otherPhone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UsersAddress{" + "uaID=" + uaID + ", userID=" + userID + ", pname=" + pname + ", dname=" + dname + ", wname=" + wname + ", prname=" + prname + ", strname=" + strname + ", detailAdress=" + detailAdress + ", phone=" + phone + ", email=" + email + ", fullname=" + fullname + ", otherPhone=" + otherPhone + ", status=" + status + '}';
    }
    

    
    
}
