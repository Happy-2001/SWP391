/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dal.CustomerDAO;
import java.util.ArrayList;
import java.util.List;
import model.Customers;
import model.User;

/**
 *
 * @author anhvo
 */
public class NewClass {
    public static void main(String[] args) {
        CustomerDAO db = new CustomerDAO();
        List<Customers> list = db.listAll();
        for (Customers c : list){
            List<User> ls = new ArrayList<>();
            ls.add(c.getUs());
            for (User u : ls){
                System.out.println(u.getUserid());
            }         
        }
    }
}
