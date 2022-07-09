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
    public Suppliers getSupById(int id) {
        String sql = "SELECT ur.roleID, ua.user_id, ua.user_name,\n" +
                    "ua.first_name, ua.middle_name, ua.last_name,\n" +
                    "ua.gender, ua.DOB, ua.status_id, uad._name,\n" +
                    "eca.email, eca.telephone, eca.webSite, eca.photo\n" +
                    "FROM\n" +
                    "(((`user_accounts` AS ua INNER JOIN `user_role` AS ur ON ua.`user_id` = ur.`userID`)\n" +
                    "INNER JOIN\n" +
                    "(SELECT * FROM `province` JOIN `user_address`\n" +
                    "ON `province`.`id` = `user_address`.`provinceID`) AS uad\n" +
                    "ON ua.`user_id` = uad.`userID`)\n" +
                    "INNER JOIN `electronicaddress` AS eca ON ua.`user_id` = eca.`eaID`)\n" +
                    "WHERE ur.roleID = 3 AND ua.user_id = ?";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Customers c = new Customers();
                c.setUs(new User(rs.getInt("ua.user_id"), rs.getString("ua.user_name"),
                                rs.getString("ua.first_name"),rs.getString("ua.middle_name"), 
                                rs.getString("ua.last_name"), rs.getInt("ua.gender"),
                                rs.getDate("ua.DOB"), rs.getInt("ua.status_id"), 
                                rs.getString("eca.email"), rs.getString("eca.telephone"),
                                rs.getString("eca.photo"), new Role(rs.getInt("ur.roleID"))));
                c.setUad(new Address(new Provinces(rs.getString("uad._name"))));
                return c;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
        return null;
    }
}
