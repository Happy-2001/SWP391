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
public class AddressDetail {
    private String addressDetail,provinceID,districtID,subDistrictID;

    public AddressDetail() {
    }

    public AddressDetail(String addressDetail, String provinceID, String districtID, String subDistrictID) {
        this.addressDetail = addressDetail;
        this.provinceID = provinceID;
        this.districtID = districtID;
        this.subDistrictID = subDistrictID;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
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
    
    
}
