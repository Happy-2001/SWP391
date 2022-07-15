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
public class Supplier_address {
    private int supID;
    Provinces  proID;
    District disID;
    SubDistrict wardID;
    Street  streetID;
    project  projectID;
    ElectronicAddress  eaID;
    private String addDetail;
    String telephone;
    String fax;
    String email;
    
    public Supplier_address(){
    
    }

    public Supplier_address(Provinces  proID,District disID, SubDistrict wardID, Street streetID, project projectID,ElectronicAddress eaID,String telephone,String fax,String email, String addDetail) {
        this.proID=proID;
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

    
    

    public Supplier_address(int supID, Provinces proID, District disID, SubDistrict wardID, Street streetID, project projectID, ElectronicAddress eaID, String addDetail) {
        this.supID = supID;
        this.proID = proID;
        this.disID = disID;
        this.wardID = wardID;
        this.streetID = streetID;
        this.projectID = projectID;
        this.eaID = eaID;
        this.addDetail = addDetail;
    }

    public int getSupID() {
        return supID;
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
    
    public void setSupID(int supID) {
        this.supID = supID;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    
    public Provinces getProID() {
        return proID;
    }

    public void setProID(Provinces proID) {
        this.proID = proID;
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

    public String getAddDetail() {
        return addDetail;
    }

    public void setAddDetail(String addDetail) {
        this.addDetail = addDetail;
    }

    
    

}
