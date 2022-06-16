/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import com.mysql.cj.xdevapi.Result;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Role;

/**
 *
 * @author Administrator
 */
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
    public static void main(String[] args) {
        RoleDAO db = new RoleDAO();
        ArrayList<Role> list = db.getRoleList();
        for (Role role : list) {
            System.out.println(role.getNameRole());
        }
    }
}
