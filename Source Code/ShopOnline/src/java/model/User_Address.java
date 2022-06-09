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
public class User_Address {
    private String userID,countryID,provinceID,districtID,subDistrictID,eaID,addressDetail;

    public User_Address() {
    }

    public User_Address(String userID, String countryID, String provinceID, String districtID, String subDistrictID, String eaID, String addressDetail) {
        this.userID = userID;
        this.countryID = countryID;
        this.provinceID = provinceID;
        this.districtID = districtID;
        this.subDistrictID = subDistrictID;
        this.eaID = eaID;
        this.addressDetail = addressDetail;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getCountryID() {
        return countryID;
    }

    public void setCountryID(String countryID) {
        this.countryID = countryID;
    }

    public String getProvinceID() {
        return provinceID;
    }

    public void setProvinceID(String provinceID) {
        this.provinceID = provinceID;
    }

    public String getDistrictID() {
        return districtID;
    }

    public void setDistrictID(String districtID) {
        this.districtID = districtID;
    }

    public String getSubDistrictID() {
        return subDistrictID;
    }

    public void setSubDistrictID(String subDistrictID) {
        this.subDistrictID = subDistrictID;
    }

    public String getEaID() {
        return eaID;
    }

    public void setEaID(String eaID) {
        this.eaID = eaID;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }
    
    
    
}
