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
    private int eaID;
    private String addDetail;
    
    public Supplier_address(){
    
    }

    public Supplier_address(Provinces  proID,District disID, SubDistrict wardID, Street streetID, project projectID, String addDetail) {
        this.proID=proID;
        this.disID = disID;
        this.wardID = wardID;
        this.streetID = streetID;
        this.projectID = projectID;
        this.addDetail = addDetail;
    }

    
    

    public Supplier_address(int supID, Provinces proID, District disID, SubDistrict wardID, Street streetID, project projectID, int eaID, String addDetail) {
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

    public void setSupID(int supID) {
        this.supID = supID;
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

    public int getEaID() {
        return eaID;
    }

    public void setEaID(int eaID) {
        this.eaID = eaID;
    }

    public String getAddDetail() {
        return addDetail;
    }

    public void setAddDetail(String addDetail) {
        this.addDetail = addDetail;
    }

    
    

}
