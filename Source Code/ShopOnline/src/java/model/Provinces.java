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
public class Provinces extends Countries{
    private String containerID;

    public Provinces() {
    }

    public Provinces(String containerID) {
        this.containerID = containerID;
    }

    public Provinces( String id, String name,String containerID) {
        super(id, name);
        this.containerID = containerID;
    }

    public String getCountryid() {
        return containerID;
    }

    public void setCountryid(String containerID) {
        this.containerID = containerID;
    }
    
    
}
