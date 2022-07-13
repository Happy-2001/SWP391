/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dal.AddressDAO;
import dal.CartDAO;
import dal.CustomerDAO;
import dal.OrderDAO;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import model.Cart;
import model.Customers;
import model.Orders;
import model.Provinces;
import model.User;

/**
 *
 * @author anhvo
 */
public class demo {
    public static void main(String[] args) {
        String id = "5";
        
        CartDAO db = new CartDAO();
        OrderDAO odb = new OrderDAO();
        
        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");  
        Date date = new Date();
        odb.insertOrder(fm.format(date), Integer.parseInt(id));
        Orders od = odb.getOrderLatest();
        System.out.println(od.getOrderID());
//        
        ArrayList<Cart> carts = db.listById(Integer.parseInt(id));
        for (Cart o : carts) {
            odb.insertOrderD(o.getQuantity(), od.getOrderID(), o.getProduct().getId());
        }
        
//        db.deleteByCartID(Integer.parseInt(id));
        
        
    }
}
