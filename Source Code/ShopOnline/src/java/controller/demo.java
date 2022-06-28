/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dal.CartDAO;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import model.Cart;

/**
 *
 * @author anhvo
 */
public class demo {
    public static void main(String[] args) {
        String cid = "5";
        
        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");  
        Date date = new Date(); 
        
        CartDAO db = new CartDAO();
        List<Cart> list = db.listAllCart();
        for (Cart c : list) {
            if(Integer.parseInt(cid) != c.getUserId()){
                db.addCart(Integer.parseInt(cid), fm.format(date), fm.format(date));
            }
        }
    }
}
