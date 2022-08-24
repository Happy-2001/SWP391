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
public class Shipper_all {
    Shipper ship;
    Shipper_Address ship_add;
    
    public Shipper_all(){
        
    }

    public Shipper_all(Shipper ship, Shipper_Address ship_add) {
        this.ship = ship;
        this.ship_add = ship_add;
    }

    public Shipper getShip() {
        return ship;
    }

    public void setShip(Shipper ship) {
        this.ship = ship;
    }

    public Shipper_Address getShip_add() {
        return ship_add;
    }

    public void setShip_add(Shipper_Address ship_add) {
        this.ship_add = ship_add;
    }
    
}
