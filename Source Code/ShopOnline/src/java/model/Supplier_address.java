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
    private int proID;
    private int disID;
    private int wardID;
    private int streetID;
    private int projectID;
    private int eaID;
    private String addDetail;
    
    public Supplier_address(){
    
    }

    public Supplier_address(int supID, int proID, int disID, int wardID, int streetID, int projectID, int eaID, String addDetail) {
        this.supID = supID;
        this.proID = proID;
        this.disID = disID;
        this.wardID = wardID;
        this.streetID = streetID;
        this.projectID = projectID;
        this.eaID = eaID;
        this.addDetail = addDetail;
    }
    
    public Supplier_address( int proID, int disID, int wardID, int streetID, int projectID, int eaID, String addDetail) {
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

    public int getProID() {
        return proID;
    }

    public void setProID(int proID) {
        this.proID = proID;
    }

    public int getDisID() {
        return disID;
    }

    public void setDisID(int disID) {
        this.disID = disID;
    }

    public int getWardID() {
        return wardID;
    }

    public void setWardID(int wardID) {
        this.wardID = wardID;
    }

    public int getStreetID() {
        return streetID;
    }

    public void setStreetID(int streetID) {
        this.streetID = streetID;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
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

    @Override
    public String toString() {
        return "Supplier_address{" + "supID=" + supID + ", proID=" + proID + ", disID=" + disID + ", wardID=" + wardID + ", streetID=" + streetID + ", projectID=" + projectID + ", eaID=" + eaID + ", addDetail=" + addDetail + '}';
    }
    

}
