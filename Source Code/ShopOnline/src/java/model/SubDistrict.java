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
public class SubDistrict {
    private String subDistrictID,name,prefix,provinceID,districtID;

    public SubDistrict() {
    }

    public SubDistrict(String subDistrictID, String name, String prefix, String provinceID, String districtID) {
        this.subDistrictID = subDistrictID;
        this.name = name;
        this.prefix = prefix;
        this.provinceID = provinceID;
        this.districtID = districtID;
    }

    public String getSubDistrictID() {
        return subDistrictID;
    }

    public void setSubDistrictID(String subDistrictID) {
        this.subDistrictID = subDistrictID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
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
    
}
