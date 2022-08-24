package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Customers;
import model.Role;
import model.User;
import model.Address;
import model.District;
import model.Provinces;
import model.SubDistrict;

/**
 *
 * @author anhvo
 */
public class CustomerDAO {
    DBConnect mysqlConnect = new DBConnect();
    
    public List<Customers> listAll() {
        List<Customers> cus = new ArrayList<>();
        String sql = "SELECT ur.roleID, ua.user_id, ua.user_name, ua.first_name,\n" +
                    "ua.middle_name, ua.last_name, ua.gender, ua.DOB, ua.status_id,\n" +
                    "uad._name, eca.email, eca.telephone, eca.photo, uad.status\n" +
                    "FROM\n" +
                    "(((`user_accounts` AS ua INNER JOIN `user_role` AS ur ON ua.`user_id` = ur.`userID`)\n" +
                    "INNER JOIN\n" +
                    "(SELECT * FROM `province` JOIN `user_address`\n" +
                    "ON `province`.`id` = `user_address`.`provinceID`) AS uad\n" +
                    "ON ua.`user_id` = uad.`userID`)\n" +
                    "INNER JOIN `electronicaddress` AS eca ON ua.`user_id` = eca.`eaID`)\n" +
                    "WHERE ur.roleID = 3 AND uad.status = 'default'";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Customers c = new Customers();
                c.setUs(new User(rs.getInt("ua.user_id"), rs.getString("ua.user_name"),
                                rs.getString("ua.first_name"),rs.getString("ua.middle_name"), 
                                rs.getString("ua.last_name"), rs.getInt("ua.gender"),
                                rs.getString("ua.DOB"), rs.getInt("ua.status_id"), 
                                rs.getString("eca.email"), rs.getString("eca.telephone"),
                                rs.getString("eca.photo"), new Role(rs.getInt("ur.roleID"))));
                c.setUad(new Address(new Provinces(rs.getString("uad._name")), rs.getString("uad.status")));
                cus.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
        return cus;
    }
    
    public Customers getCusByUserId(int id) {
        String sql = "SELECT ur.roleID, ua.user_id, ua.user_name,\n" +
                    "ua.password, ua.first_name, ua.middle_name, ua.last_name,\n" +
                    "ua.gender, ua.DOB, ua.status_id, uad._name,\n" +
                    "uad.districtID, uad.wardID, uad.addressDetail,\n" +
                    "uad.status, eca.email, eca.telephone,\n" +
                    "eca.webSite, eca.photo FROM\n" +
                    "(((`user_accounts` AS ua INNER JOIN `user_role` AS ur ON ua.`user_id` = ur.`userID`)\n" +
                    "INNER JOIN\n" +
                    "(SELECT * FROM `province` JOIN `user_address`\n" +
                    "ON `province`.`id` = `user_address`.`provinceID`) AS uad\n" +
                    "ON ua.`user_id` = uad.`userID`)\n" +
                    "INNER JOIN `electronicaddress` AS eca ON ua.`user_id` = eca.`eaID`)\n" +
                    "WHERE ur.roleID = 3 AND uad.status = 'default' AND ua.user_id = ?";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Customers c = new Customers();
                c.setUs(new User(rs.getInt("ua.user_id"), rs.getString("ua.user_name"), rs.getString("ua.password"),
                                rs.getString("ua.first_name"),rs.getString("ua.middle_name"), 
                                rs.getString("ua.last_name"), rs.getInt("ua.gender"),
                                rs.getString("ua.DOB"), rs.getInt("ua.status_id"), 
                                rs.getString("eca.email"), rs.getString("eca.telephone"),
                                rs.getString("eca.photo"), new Role(rs.getInt("ur.roleID"))));
                c.setUad(new Address(new Provinces(rs.getString("uad._name")),
                                    new District(rs.getInt("uad.districtID")),
                                    new SubDistrict(rs.getInt("uad.wardID")),
                                    rs.getString("uad.addressDetail"), rs.getString("uad.status")));
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
