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
public class project {
    private int id;
    private String name;
    private int _province_id;
    private int _district_id;
    private Double _lng;
    private Double _lat;
    
    public project(){
        
    }
    public project(int id){
        this.id=id;
    }

    public project(int id, String name, int _province_id, int _district_id, Double _lng, Double _lat) {
        this.id = id;
        this.name = name;
        this._province_id = _province_id;
        this._district_id = _district_id;
        this._lng = _lng;
        this._lat = _lat;
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

    public int getProvince_id() {
        return _province_id;
    }

    public void setProvince_id(int _province_id) {
        this._province_id = _province_id;
    }

    public int getDistrict_id() {
        return _district_id;
    }

    public void setDistrict_id(int _district_id) {
        this._district_id = _district_id;
    }

    public Double getLng() {
        return _lng;
    }

    public void setLng(Double _lng) {
        this._lng = _lng;
    }

    public Double getLat() {
        return _lat;
    }

    public void setLat(Double _lat) {
        this._lat = _lat;
    }
    
}
