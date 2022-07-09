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
public class SupDetail {
    Suppliers sup;
    Supplier_address sup_add;
    public SupDetail(){
        
    }

    public SupDetail(Suppliers sup, Supplier_address sup_add) {
        this.sup = sup;
        this.sup_add = sup_add;
    }

    public Suppliers getSup() {
        return sup;
    }

    public void setSup(Suppliers sup) {
        this.sup = sup;
    }

    public Supplier_address getSup_add() {
        return sup_add;
    }

    public void setSup_add(Supplier_address sup_add) {
        this.sup_add = sup_add;
    }
    
}
