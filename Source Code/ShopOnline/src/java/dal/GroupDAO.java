/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.GroupChat;
import model.Product;
import model.User;

/**
 *
 * @author Administrator
 */
public class GroupDAO {

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
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
            ps.executeUpdate();
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
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GroupDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
    }

    //get groupID by userID 
    public String getGroupIDbyUserID(String userID) {
        String groupID = "";
        String sql = "SELECT `user_group`.`groupID` FROM  user_group WHERE userID = ?";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setString(1, userID);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                groupID = rs.getString(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
        return groupID;
    }

    //get max groupID 
    public String getMaxGroupIDb() {
        String groupID = "";
        String sql = "SELECT MAX(groupID) FROM  `Group`";
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                groupID = rs.getString(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            mysqlConnect.disconnect();
        }
        return groupID;
    }

    public ArrayList<GroupChat> getGroupChat() {
        ArrayList<GroupChat> list = new ArrayList<>();
        try {
            String sql = " SELECT tb2.* FROM\n"
                    + " (SELECT groupName, MAX(createDate)as createDate FROM \n"
                    + "(SELECT  mrID,groupName,m.messageBody,m.createDate FROM\n"
                    + "(SELECT mr.messageID,mr.mrID,`group`.`groupName` FROM message_recipient mr INNER JOIN `Group` \n"
                    + "ON `Group`.`groupID` = mr.recipientGroupID) as rs1 INNER JOIN messages m\n"
                    + "ON m.messageID = rs1.messageID) as rs2\n"
                    + "group BY (groupName) ) as tb1\n"
                    + "LEFT join\n"
                    + "(SELECT  mrID,groupName,m.messageBody,m.createDate FROM\n"
                    + "(SELECT mr.messageID,mr.mrID,`group`.`groupName` FROM message_recipient mr INNER JOIN `Group` \n"
                    + "ON `Group`.`groupID` = mr.recipientGroupID) as rs1 INNER JOIN messages m\n"
                    + "ON m.messageID = rs1.messageID) as tb2\n"
                    + "ON tb2.createDate = tb1.createDate ";

            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                GroupChat u = new GroupChat();

                u.setId(rs.getString(1));
                u.setName(rs.getString(2));
                u.setContent(rs.getString(3));
                u.setTime(rs.getString(4));

                list.add(u);
            }

        } catch (SQLException ex) {
            Logger.getLogger(MessageDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            mysqlConnect.disconnect();
        }
        return list;
    }
}
