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
import model.Supplier_address;

/**
 *
 * @author nguye
 */
public class SupAdressDAO extends DBConnect{
    
    DBConnect mysqlConnect = new DBConnect();
    
//    public Supplier_address getSupAdressById(int id) {
//        String sql = "SELECT * FROM `supplier_address` WHERE supplierID=?";
//        try {
//            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
//            statement.setInt(1, id);
//            ResultSet rs = statement.executeQuery();
//            if (rs.next()) {
//                Supplier_address u = new Supplier_address();
//                u.setDisID(rs.getInt("supplierID"));
//                u.setProID(rs.getInt("provinceID"));
//                u.setDisID(rs.getInt("districtID"));
//                u.setWardID(rs.getInt("wardID"));
//                u.setStreetID(rs.getInt("streetID"));
//                u.setProjectID(rs.getInt("projectID"));
//                u.setEaID(rs.getInt("eaID"));
//                u.setAddDetail(rs.getString("addressDetail"));
//                return u;
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(SupAdressDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            mysqlConnect.disconnect();
//        }
//        return null;
//    }
}
