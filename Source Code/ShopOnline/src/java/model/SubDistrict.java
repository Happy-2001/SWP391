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
    private int subDistrictID;
    private String name;
    private String prefix;
    private int provinceID;
    private int districtID;

    public SubDistrict() {
    }
    
    public SubDistrict(int subDistrictID) {
        this.subDistrictID = subDistrictID;
    }

    public SubDistrict(int subDistrictID, String name, String prefix, int provinceID, int districtID) {
        this.subDistrictID = subDistrictID;
        this.name = name;
        this.prefix = prefix;
        this.provinceID = provinceID;
        this.districtID = districtID;
    }

    public int getSubDistrictID() {
        return subDistrictID;
    }

    public void setSubDistrictID(int subDistrictID) {
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

    public int getProvinceID() {
        return provinceID;
    }

    public void setProvinceID(int provinceID) {
        this.provinceID = provinceID;
    }

    public int getDistrictID() {
        return districtID;
    }

    public void setDistrictID(int districtID) {
        this.districtID = districtID;
    }
    
}