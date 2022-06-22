/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class GroupDAO {
     DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
   LocalDateTime now = LocalDateTime.now();  
  String getTime = (dtf.format(now));  
    
    DBConnect mysqlConnect = new DBConnect();

    public void addGroup(String groupName) {
        String sql = "INSERT INTO `group` (groupName,createDate) VALUES\n"
                + "(?,?);";
        
        try {
            PreparedStatement ps = mysqlConnect.connect().prepareStatement(sql);
            ps.setString(1, groupName);
            ps.setString(2, getTime);
        } catch (SQLException ex) {
            Logger.getLogger(GroupDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
    }
    
    public void addUserGroup(String userID, String groupID) {
        String sql = "INSERT INTO `User_Group` (userID,groupID,createDate) VALUES\n"
                + "(?,?,?);";
        
        try {
            PreparedStatement ps = mysqlConnect.connect().prepareStatement(sql);
            ps.setString(1, userID);
            ps.setString(2, groupID);
            ps.setString(3, getTime);
        } catch (SQLException ex) {
            Logger.getLogger(GroupDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
    }
}
