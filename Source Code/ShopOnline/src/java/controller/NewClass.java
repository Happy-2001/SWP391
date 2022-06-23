/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author anhvo
 */
public class NewClass {
    public static void main(String[] args) {
        String s = ("1m s2,3");
        String[] itemID = s.split("//S+");
        StringBuilder sb = new StringBuilder();
        sb.append(itemID[0]);
//        for(int i=1; i<itemID.length; i++){
//            sb.append(",");
//            sb.append(itemID[i]);
//        }
System.out.println(itemID[0]);
        System.out.println(sb.toString());
    }
}
