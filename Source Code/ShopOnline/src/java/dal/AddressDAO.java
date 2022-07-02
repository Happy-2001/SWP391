/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class AddressDAO {

    DBConnect mysqlConnect = new DBConnect();

    public void insertCountry(String name) {
        String sql = "";
        try {
            PreparedStatement ps = mysqlConnect.connect().prepareStatement(sql);
            ps.setString(1, name);
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(AddressDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
    }

    public void insertAddress(String table, String name, String containerID) {
        String sql = "";
        try {
            PreparedStatement ps = mysqlConnect.connect().prepareStatement(sql);
            ps.setString(1, table);
            ps.setString(2, name);
            ps.setString(3, containerID);

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(AddressDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
    }

    public String getEaIDbyUserID(String UserID) {
        String eaID = "";
        String sql = "SELECT ea.eaID FROM `electronicaddress` ea INNER JOIN user_address ua \n"
                + "ON ua.eaID = ea.eaID WHERE ua.userID = ?";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setString(1,UserID);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                eaID = rs.getString(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
        return eaID;
    }

}
