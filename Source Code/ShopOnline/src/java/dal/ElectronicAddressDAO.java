/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.AddressDetail;
import model.ElectronicAddress;
import model.User;

/**
 *
 * @author Administrator
 */
public class ElectronicAddressDAO {
    DBConnect mysqlConnect = new DBConnect();
    
    public void insert(ElectronicAddress e) {
        try {
            String sql = "INSERT INTO `electronicaddress`"
                    + " ( `webSite`, `telephone`, `fax`, `email`, `photo`) VALUES"
                    + "( ?, ?, ?, ?, ?);";
            PreparedStatement s = mysqlConnect.connect().prepareStatement(sql);
            s.setString(1,"");
            s.setString(2, e.getTelephone());
            s.setString(3, "");
            s.setString(4, e.getEmail());
            s.setString(5, "");
            
            s.executeUpdate();
        } catch (SQLException x) {
            System.out.println(x);
        } finally {
            mysqlConnect.disconnect();
        }
    }
    
    
    public String getEaIDbyEmail(String email) {
        String eaID = "";
        String sql = "SELECT eaID FROM `electronicaddress` WHERE email = ?";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setString(1, email);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                eaID = rs.getString(1);
            }
        } catch (SQLException ex) {
            
        } finally {
            mysqlConnect.disconnect();
        }
        return eaID;
    }
    public static void main(String[] args) {
        ElectronicAddressDAO e = new ElectronicAddressDAO();
        System.out.println(e.getEaIDbyEmail("hoangnvhe151236@fpt.edu.vn"));
            
    }
}
