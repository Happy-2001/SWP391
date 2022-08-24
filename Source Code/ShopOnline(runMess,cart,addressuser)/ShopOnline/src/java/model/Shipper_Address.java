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
public class Shipper_Address {
    private int id;
    Provinces provinceID;
    District  disID;
    SubDistrict wardID;
    Street streetID;
    project projectID;      
    ElectronicAddress  eaID;         
    private String telephone;
    private String fax;
    private String email;
    private String addDetail;
    public Shipper_Address(){
        
    }

    public Shipper_Address(Provinces provinceID, District disID, SubDistrict wardID, Street streetID, project projectID, String telephone, String fax, String email, String addDetail) {
        this.provinceID = provinceID;
        this.disID = disID;
        this.wardID = wardID;
        this.streetID = streetID;
        this.projectID = projectID;
        this.telephone = telephone;
        this.fax = fax;
        this.email = email;
        this.addDetail = addDetail;
    }

    
    
    public Shipper_Address(int id, Provinces provinceID, District disID, SubDistrict wardID, Street streetID, project projectID, ElectronicAddress eaID, String telephone, String fax, String email, String addDetail) {
        this.id = id;
        this.provinceID = provinceID;
        this.disID = disID;
        this.wardID = wardID;
        this.streetID = streetID;
        this.projectID = projectID;
        this.eaID = eaID;
        this.telephone = telephone;
        this.fax = fax;
        this.email = email;
        this.addDetail = addDetail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Provinces getProvinceID() {
        return provinceID;
    }

    public void setProvinceID(Provinces provinceID) {
        this.provinceID = provinceID;
    }

    public District getDisID() {
        return disID;
    }

    public void setDisID(District disID) {
        this.disID = disID;
    }

    public SubDistrict getWardID() {
        return wardID;
    }

    public void setWardID(SubDistrict wardID) {
        this.wardID = wardID;
    }

    public Street getStreetID() {
        return streetID;
    }

    public void setStreetID(Street streetID) {
        this.streetID = streetID;
    }

    public project getProjectID() {
        return projectID;
    }

    public void setProjectID(project projectID) {
        this.projectID = projectID;
    }

    public ElectronicAddress getEaID() {
        return eaID;
    }

    public void setEaID(ElectronicAddress eaID) {
        this.eaID = eaID;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddDetail() {
        return addDetail;
    }

    public void setAddDetail(String addDetail) {
        this.addDetail = addDetail;
    }

    @Override
    public String toString() {
        return "Shipper_Address{" + "id=" + id + ", provinceID=" + provinceID + ", disID=" + disID + ", wardID=" + wardID + ", streetID=" + streetID + ", projectID=" + projectID + ", eaID=" + eaID + ", telephone=" + telephone + ", fax=" + fax + ", email=" + email + ", addDetail=" + addDetail + '}';
    }

    

    

    

    
    
}
