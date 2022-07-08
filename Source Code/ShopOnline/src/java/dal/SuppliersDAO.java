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
import java.util.List;
import model.Suppliers;
import model.User;

/**
 *
 * @author nguye
 */
public class SuppliersDAO extends DBConnect{
    DBConnect mysqlConnect = new DBConnect();
    public List<Suppliers> listSupplier() {
        List<Suppliers> suppliers = new ArrayList<>();
        String sql = "SELECT * FROM `suppliers`";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Suppliers u = new Suppliers();
                u.setId(rs.getInt("supplierID"));
                u.setName(rs.getString("companyName"));
                u.setContactName(rs.getString("contactName"));
                u.setContactTitle(rs.getString("contactTitle"));
                u.setDob(rs.getDate("DOB"));
                u.setGender(rs.getInt("gender"));
                u.setCreator(rs.getInt("creator"));
                suppliers.add(u);
            }
            return suppliers;
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
        return null;
    }
    public List<Suppliers> listSupplierDetail() {
        return null;
    }
}
