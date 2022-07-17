/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Administrator
 */
public class UserAddress {
    private int uaID;
    private String name;
    private int userID;
    Provinces proID;
    SubDistrict disID;
    Ward wardID;
    project projectID;
    ElectronicAddress eaID;
    String otherphone;
    String addDetail;
    String status;
    
    public UserAddress(){
        
    }
    public UserAddress(Provinces proID){
        this.proID=proID;
    }
    public UserAddress(int uaID, String name, int userID, Provinces proID, SubDistrict disID, Ward wardID, project projectID, ElectronicAddress eaID, String otherphone, String addDetail, String status) {
        this.uaID = uaID;
        this.name = name;
        this.userID = userID;
        this.proID = proID;
        this.disID = disID;
        this.wardID = wardID;
        this.projectID = projectID;
        this.eaID = eaID;
        this.otherphone = otherphone;
        this.addDetail = addDetail;
        this.status = status;
    }
    
    public void setUaID(int uaID) {
        this.uaID = uaID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setProID(Provinces proID) {
        this.proID = proID;
    }

    public void setDisID(SubDistrict disID) {
        this.disID = disID;
    }

    public void setWardID(Ward wardID) {
        this.wardID = wardID;
    }

    public void setProjectID(project projectID) {
        this.projectID = projectID;
    }

    public void setEaID(ElectronicAddress eaID) {
        this.eaID = eaID;
    }

    public void setOtherphone(String otherphone) {
        this.otherphone = otherphone;
    }

    public void setAddDetail(String addDetail) {
        this.addDetail = addDetail;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getUaID() {
        return uaID;
    }

    public String getName() {
        return name;
    }

    public int getUserID() {
        return userID;
    }

    public Provinces getProID() {
        return proID;
    }

    public SubDistrict getDisID() {
        return disID;
    }

    public Ward getWardID() {
        return wardID;
    }

    public project getProjectID() {
        return projectID;
    }

    public ElectronicAddress getEaID() {
        return eaID;
    }

    public String getOtherphone() {
        return otherphone;
    }

    public String getAddDetail() {
        return addDetail;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "UserAddress{" + "uaID=" + uaID + ", name=" + name + ", userID=" + userID + ", proID=" + proID + ", disID=" + disID + ", wardID=" + wardID + ", projectID=" + projectID + ", eaID=" + eaID + ", otherphone=" + otherphone + ", addDetail=" + addDetail + ", status=" + status + '}';
    }
    

    
    
    
}
