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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Message;
import model.User;

/**
 *
 * @author Administrator
 */
public class MessengerDAO {

    DBConnect mysqlConnect = new DBConnect();

    public void addMessage(String content, String fromid, String toid, String sendTime) {
        try {
            String sql = "INSERT INTO `messengers` (`content`, `fromID`, `toID`, `sendTime`) VALUES\n"
                    + "(?,?,?)";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setString(1, content);
            statement.setString(2, fromid);
            statement.setString(3, toid);
            statement.setString(4, sendTime);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MessengerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<User> getMesstoAdmin(String adminID) {
        ArrayList<User> list = new ArrayList<>();
        try {
            String sql = "SELECT  DISTINCT infUSER.* FROM\n"
                    + "(SELECT DISTINCT user_accounts.* from messengers INNER JOIN user_accounts ON user_accounts.user_id = messengers.fromID WHERE messengers.toID = ? ) as listUSERsend INNER join\n"  // ? in this line
                    + "(SELECT user_id,user_name,`password`,first_name,middle_name,last_name,gender,telephone as phone,email,status_id FROM\n"
                    + "(SELECT ua.*, ac.* FROM user_address AS ua INNER JOIN user_accounts as ac \n"
                    + " ON ua.userID = ac.user_id) AS rs1\n"
                    + "INNER JOIN electronicaddress AS ea ON ea.eaID = rs1.eaID) as infUSER WHERE infUSER.user_id = listUSERsend.user_id";

            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setString(1, adminID);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                 User u = new User();

                u.setUserid(rs.getInt("user_id"));
                u.setUsername(rs.getString("user_name"));
                u.setPassword(rs.getString("password"));
                u.setFirstname(rs.getString("first_name"));
                u.setMiddlename(rs.getString("middle_name"));
                u.setLastname(rs.getString("last_name"));
                u.setGender(rs.getInt("gender"));
                u.setPhone(rs.getString("phone"));
                u.setEmail(rs.getString("email"));
                u.setStatus(rs.getInt("status_id"));
                list.add(u);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(MessengerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            mysqlConnect.disconnect();
        }
        return null;
    }

    public ArrayList<Message> getAllMessageofUser(String toid, String fromid) {
        ArrayList<Message> list = new ArrayList<>();
        try {
            String sql = "select messengerID,fromID  ,toID,sendTime,receivedTime,content,isRead from messengers as m inner join user_accounts as acc on user_id = m.fromID where toID = ? and fromID = ?";
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
            statement.setString(1, toid);
            statement.setString(2, fromid);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Message s = new Message();
                s.setId(rs.getString("messengerID"));
                s.setFromID(rs.getString("fromID"));
                s.setToID(rs.getString("toID"));
                s.setContent(rs.getString("content"));
                s.setSendTime(rs.getString("sendTime"));
                s.setReceivedTime(rs.getString("receivedTime"));
                s.setIsread(rs.getString("isRead"));
                list.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MessengerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            mysqlConnect.disconnect();
        }
        return list;
    }
    public static void main(String[] args) {
        MessengerDAO m = new MessengerDAO();
        ArrayList<Message> list =  m.getAllMessageofUser("1", "3");
        for (Message message : list) {
            System.out.println(message.getContent());
        }
    }
}
