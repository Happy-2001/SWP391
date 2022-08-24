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
public class Street {
    private int id;
    private String name;
    private String prefix;
    private int provine_id;
    private int district_id;

    public Street(){
        
    }
    
    public Street(int id){
        this.id=id;
    }
    
    public Street(int id, String name, String prefix, int provine_id, int district_id) {
        this.id = id;
        this.name = name;
        this.prefix = prefix;
        this.provine_id = provine_id;
        this.district_id = district_id;
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

    public int getProvine_id() {
        return provine_id;
    }

    public void setProvine_id(int provine_id) {
        this.provine_id = provine_id;
    }

    public int getDistrict_id() {
        return district_id;
    }

    public void setDistrict_id(int district_id) {
        this.district_id = district_id;
    }
    
}
