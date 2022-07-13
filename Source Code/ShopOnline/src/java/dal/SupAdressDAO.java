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
import model.District;
import model.Provinces;
import model.Supplier_address;
import model.Ward;

/**
 *
 * @author nguye
 */
public class SupAdressDAO extends DBConnect{
    
    DBConnect mysqlConnect = new DBConnect();
    
    public Supplier_address getSupAdressById(int id) {
        String sql = "SELECT * FROM `supplier_address` WHERE supplierID=?";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Supplier_address u = new Supplier_address();
                u.setSupID(rs.getInt("supplierID"));
                u.setProID(new Provinces(rs.getInt("id"),rs.getString("name"),rs.getString("code")));
                u.setDisID(new District(rs.getInt("id"),rs.getString("name"),rs.getString("prefix"),rs.getString("provinceID")));
                u.setWardID(new Ward(rs.getInt("id"),rs.getString("name"),rs.getString("prefix"),rs.getInt("provinceid"),rs.getInt("districtid")));
                u.setStreetID(rs.getInt("streetID"));
                u.setProjectID(rs.getInt("projectID"));
                u.setEaID(rs.getInt("eaID"));
                u.setAddDetail(rs.getString("addressDetail"));
                return u;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SupAdressDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
        return null;
    }
}
