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
import model.Shipper;

/**
 *
 * @author nguye
 */
public class ShipperDAO extends DBConnect {
    
    DBConnect mysqlConnect = new DBConnect();
    
    public ArrayList<Shipper> listShipper() {
        ArrayList<Shipper> shipper = new ArrayList<>();
        String sql = "SELECT * FROM `shippers`";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Shipper u = new Shipper();
                u.setId(rs.getInt("shipperID"));
                u.setName(rs.getString("shipperName"));
                u.setDob(rs.getDate("DOB"));
                u.setGender(rs.getInt("gender"));
                u.setCreator(rs.getInt("creator"));
                u.setCreateOn(rs.getDate("createOn"));
                u.setUpdateOn(rs.getDate("updateOn"));
                shipper.add(u);
            }
            return shipper;
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
        return null;
    }
    public static void main(String[] args) {
        ShipperDAO dao = new ShipperDAO();
        ArrayList<Shipper> s = dao.listShipper();
        for(Shipper o : s){
            System.out.println(o.getName());
        }
    }
}
