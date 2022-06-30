package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Role;
import model.User;


public class RoleDAO {

    DBConnect mysqlConnect = new DBConnect();
    
    public ArrayList<Role> getRoleList() {
        String sql = "SELECT * FROM roles";
        ArrayList<Role> list = new ArrayList<>();
        try {
            PreparedStatement ps = mysqlConnect.connect().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Role role = new Role();
                role.setId(rs.getInt("roleID"));
                role.setNameRole(rs.getString("name"));
                list.add(role);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(RoleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            mysqlConnect.disconnect();
        }
        return null;
    }
    // get role user
    public ArrayList<Role> getRoleUser(String userID) {
        String sql = "SELECT r.roleID,r.name FROM user_role as ul INNER JOIN roles as r ON ul.roleID = r.roleID\n"
                + "WHERE ul.userID = ?";
        ArrayList<Role> list = new ArrayList<>();
        try {
            PreparedStatement ps = mysqlConnect.connect().prepareStatement(sql);
            ps.setString(1, userID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Role role = new Role();
                role.setId(rs.getInt("roleID"));
                role.setNameRole(rs.getString("name"));
                list.add(role);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(RoleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            mysqlConnect.disconnect();
        }
        return null;
    }
    
    public User getUserRole(String username){ //phan nay can dung, dung ai xoa      Ok toi se khong xoa dau!!!
        try {
            String sql = "SELECT ua.user_id, ua.user_name, roleID, name FROM `user_accounts` as ua JOIN\n" +
                     "(SELECT ur.roleID, name, ur.userID FROM `user_role` as ur \n" +
                     "JOIN `roles` as r ON ur.roleID = r.roleID) as rs\n" +
                     "ON ua.user_id = rs.userID WHERE ua.user_name = ?";

            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                User u = new User();
                u.setUserid(rs.getInt("ua.user_id"));
                u.setUsername(rs.getString("ua.user_name"));
                u.setAuthority(new Role(rs.getInt("roleID"),rs.getString("name")));
                return u;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            mysqlConnect.disconnect();
        }
         return null;
    }
}
