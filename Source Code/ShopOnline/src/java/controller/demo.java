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
import java.util.Calendar;
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
        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        Date date = new Date();  
        Calendar cal = Calendar.getInstance();
        
        System.out.println("Ngay gio hien tai: " + cal.getTime());
        cal.add(Calendar.DATE, -7);
        System.out.println("15 ngay sau: " + cal.getTime());
    }
}
