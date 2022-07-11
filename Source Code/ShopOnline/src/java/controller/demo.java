/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dal.AddressDAO;
import dal.CartDAO;
import dal.CustomerDAO;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import model.Cart;
import model.Customers;
import model.Provinces;
import model.User;

/**
 *
 * @author anhvo
 */
public class demo {
    public static void main(String[] args) {
        String id = "5";
        
        CustomerDAO db = new CustomerDAO();
        Customers cus = db.getCusByUserId(Integer.parseInt(id));
        
        AddressDAO dbb = new AddressDAO();
        ArrayList<Provinces> province = dbb.getProvince();
        
        int prvid = 0;
        for(Provinces pv : province){
            if(pv.getName().equals(cus.getUad().getProvince().getName())){
                prvid = pv.getId();
            }
        }
        System.out.println(prvid);
    }
}
