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
public class Ward {
    private int id;
    private String name;
    private String prefix;
    private int provinceID;
    private int districtID;
    
    public Ward(){
        
    }

    public Ward(int id, String name, String prefix, int provinceID, int districtID) {
        this.id = id;
        this.name = name;
        this.prefix = prefix;
        this.provinceID = provinceID;
        this.districtID = districtID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
