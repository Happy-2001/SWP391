/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.User;

/**
 *
 * @author nguye
 */
public class UserDAO {
    DBConnect mysqlConnect = new DBConnect();
    
    public User getUser(String email, String password) {
        String sql = "SELECT * FROM `user_account` WHERE `email` = ? AND `password` = ?";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                User u = new User();
                u.setUserid(rs.getInt("user_id"));
                u.setUsername(rs.getString("user_name"));
                u.setPassword(password);
                u.setFullname(rs.getString("full_name"));
                u.setGender(rs.getInt("gender"));
                u.setPhone(rs.getString("phone"));
                u.setEmail(email);
                u.setStatus(rs.getInt("status_id"));
                u.setCode(rs.getString("code"));
                u.setAuthorityid(rs.getInt("authority_id"));
                return u;
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
        return null;
    }
}
