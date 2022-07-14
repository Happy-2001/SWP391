/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dal.AddressDAO;
import dal.CartDAO;
import dal.CustomerDAO;
import dal.FeedbackDAO;
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
        String fid = "5";
        String reply = "123";
        
        FeedbackDAO db = new FeedbackDAO();
        
        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");  
        Date date = new Date();  
        db.updateFb(reply, fm.format(date), Integer.parseInt(fid));
        System.out.println("Success!");
    }
}
